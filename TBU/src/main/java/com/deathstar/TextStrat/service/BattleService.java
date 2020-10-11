package com.deathstar.TextStrat.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.deathstar.domain.Squad;
import org.springframework.stereotype.Service;
import com.deathstar.domain.Emperor;

@Service
public class BattleService {

    public void attack(Squad squad, List<Squad> enemySquads) {
        getAttackTarget(enemySquads, squad.getSquadHitRange()).forEach(
                t -> {
                    t.setHp(t.getHp() -
                            (squad.getPhysicalAtt() - t.getPhysicalDef()) +
                            (squad.getMagicAtt() - t.getMagicDef())
                    );

                    if (t.getHp() <= 0) enemySquads.remove(t);
                }
        );
    }

    public List<Squad> getAttackTarget(List<Squad> squadList, long squadHitRange)  {
        return squadList.stream().limit(squadHitRange).sorted(Comparator.comparing(Squad::getHp)).collect(Collectors.toList());
    }

    public List<Squad> getHealTarget(List<Squad> squadList, long squadHitRange)  {
        return squadList.stream().limit(squadHitRange).sorted(Comparator.comparing(Squad::getHp).reversed()).collect(Collectors.toList());
    }

    public Map<String, String> createBattle(Emperor home, Emperor away) {

        Map<String, String> battleResults = new HashMap<>();

        int turns = 0;

        while (!home.getSquads().isEmpty() && !away.getSquads().isEmpty()) {

            //attack phase
            home.getSquads().stream().filter(s -> !s.hasAttacked()).findFirst().ifPresent(squad -> {
                try {
                    attack(squad, away.getSquads());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            away.getSquads().stream().filter(s -> !s.hasAttacked()).findFirst().ifPresent(squad -> {
                try {
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
        turns++;
        }

        battleResults.put("turns", String.valueOf(turns));

        if (home.getSquads().isEmpty()) { battleResults.put("winner", away.getName()); }
        else { battleResults.put("winner", home.getName()); }

        return battleResults;
    }

    private void heal(Squad squad, List<Squad> friendlySquads) {
        getHealTarget(friendlySquads, squad.getSquadHitRange()).forEach(
                t -> {
                    int postHealHp = t.getHp() + squad.getHeal();
                    t.setHp(Math.min(postHealHp, t.getMaxHp()));
                }
        );
    }
}
