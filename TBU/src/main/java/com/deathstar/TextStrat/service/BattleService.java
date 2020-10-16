package com.deathstar.TextStrat.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.deathstar.domain.BattleResult;
import com.deathstar.domain.Squad;
import org.springframework.stereotype.Service;
import com.deathstar.domain.Emperor;

@Service
public class BattleService {

    public void attack(Squad squad, List<Squad> enemySquads) {
        getAttackTarget(enemySquads, squad.getSquadHitRange(), "health").forEach(
                t -> {
                    t.setHp(t.getHp() -
                            (Math.max(squad.getPhysicalAtt() - t.getPhysicalDef(), 0)) -
                            (Math.max(squad.getMagicAtt() - t.getMagicDef(), 0))
                    );
                    if (t.getHp() <= 0) enemySquads.remove(t);
                    updateSquadStats(t);
                }
        );
        squad.setHasAttacked(true);
    }

    public List<Squad> getAttackTarget(List<Squad> squadList, long squadHitRange, String statPriority)  {
        return squadList.stream().limit(squadHitRange).sorted(UnitService.getStatComparator().get(statPriority)).collect(Collectors.toList());
    }

    private void heal(Squad squad, List<Squad> friendlySquads) {
        getHealTarget(friendlySquads, squad.getSquadHitRange()).forEach(
                t -> {
                    int postHealHp = t.getHp() + squad.getHeal();
                    t.setHp(Math.min(postHealHp, t.getMaxHp()));
                }
        );
    }

    public List<Squad> getHealTarget(List<Squad> squadList, long squadHitRange)  {
        return squadList.stream().limit(squadHitRange).sorted(Comparator.comparing(Squad::getHp).reversed()).collect(Collectors.toList());
    }

    public BattleResult createBattle(Emperor home, Emperor away) {

        int turns = 1;

        while (!home.getSquads().isEmpty() && !away.getSquads().isEmpty()) {

            //attack phase
            home.getSquads().stream().filter(s -> !s.hasAttacked()).findFirst().ifPresent(squad -> {
                try {
                    attack(squad, away.getSquads());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            int finalTurns = turns;
            away.getSquads().stream().filter(s -> !s.hasAttacked()).findFirst().ifPresent(squad -> {
                try {
                    if (finalTurns ==1) attack(squad, home.getSquads());
                    attack(squad, home.getSquads());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            //heal phase
            home.getSquads().stream().filter(s -> s.getHeal() > 0).forEach(s -> {
                try {
                    heal(s, home.getSquads());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            away.getSquads().stream().filter(s -> s.getHeal() > 0).forEach(s -> {
                try {
                    heal(s, away.getSquads());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            resetAttackBoolean(home);
            resetAttackBoolean(away);
        turns++;
        if (turns == 100) break;
        }

       return getResults(home, away, turns);


    }

    private void resetAttackBoolean(Emperor emperor) {
        if (emperor.getSquads().stream().allMatch(Squad::hasAttacked)){
            emperor.getSquads().forEach(s -> s.setHasAttacked(false));
        }
    }

    private void updateSquadStats(Squad squad) {
        int remainingUnits = (int) Math.ceil((double) squad.getHp() / squad.getUnit().getHp());
        squad.setPhysicalAtt(remainingUnits * squad.getUnit().getPhysicalAtt());
        squad.setMagicAtt(remainingUnits * squad.getUnit().getMagicAtt());
        squad.setMagicAtt(remainingUnits * squad.getUnit().getHeal());
    }

    private BattleResult getResults(Emperor home, Emperor away, int turns) {
        BattleResult battleResult = new BattleResult();
        if (home.getSquads().isEmpty()) {
            battleResult.setWinner("away");
            battleResult.setWinningSquad(away.getSquads());
            battleResult.setWinnerStatPriority(home.getStatPriority());
            battleResult.setLoserStatPriority(away.getStatPriority());
        } else {
            battleResult.setWinner("home");
            battleResult.setWinningSquad(home.getSquads());
            battleResult.setWinnerStatPriority(away.getStatPriority());
            battleResult.setLoserStatPriority(home.getStatPriority());

        }
        battleResult.setTurns(turns);

        return battleResult;
    }
}
