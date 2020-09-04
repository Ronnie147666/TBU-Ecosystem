package com.deathstar.TextStrat.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.deathstar.TextStrat.domain.Emperor;
import com.deathstar.TextStrat.properties.BattleConfiguration;
import com.deathstar.TextStrat.service.kafka.KafkaProducer;
import com.deathstar.domain.BattleDeclaration;
import com.deathstar.domain.EmperorDTO;
import com.deathstar.domain.HistoricRecordDTO;
import com.deathstar.domain.Unit;

@Service
public class WarRoom {

  @Autowired
  ContentCreation contentCreation;
  @Autowired
  CombatSystem combatSystem;
  @Autowired
  KafkaProducer producer;

  public void prepareArmy(Emperor emperor, Map<String, Integer> unitsToCreate) {

    List<Unit> army = new ArrayList<>();
    emperor.setArmySize(unitsToCreate.size());
    unitsToCreate.entrySet().forEach(e -> {

      for (int i = 1; i <= e.getValue(); i++) {
        try {
          army.add(contentCreation.createUnit(e.getKey(), String.valueOf(i), emperor.getName()));
        } catch (Exception ex) {
          BoardService.printer(("Could not create unit"));
          ex.printStackTrace();
        }
      }

    });

    emperor.setUnits(army);

  }

  @Async
  public void declareWar(BattleDeclaration battle) {

    Emperor home = new Emperor(battle.getHomeEmperor());
    prepareArmy(home, battle.getHomeUnits());
    Emperor away = new Emperor(battle.getAwayEmperor());
    prepareArmy(away, battle.getAwayUnits());

    EmperorDTO homeDTO = new EmperorDTO();
    homeDTO.setUnitList(new ArrayList<Unit>(home.getUnits()));
    homeDTO.setUnits(battle.getHomeUnits());
    homeDTO.setName(battle.getHomeEmperor());

    EmperorDTO awayDTO = new EmperorDTO();
    awayDTO.setUnitList(new ArrayList<Unit>(away.getUnits()));
    awayDTO.setUnits(battle.getAwayUnits());
    awayDTO.setName(battle.getAwayEmperor());

    HistoricRecordDTO record = battle(home, away);
    record.setHomeEmperor(homeDTO);
    record.setAwayEmperor(awayDTO);
    record.setBattleType(String.valueOf(home.getArmySize()));

    writeHistory(record);

  }

  public HistoricRecordDTO battle(Emperor home, Emperor away) {

    HistoricRecordDTO record = new HistoricRecordDTO();

    record.setDateCreated(LocalDate.now());

    BoardService.printer("The fight of light and dark begins");

    int turn = 1;

    while (!home.getUnits().isEmpty() && !away.getUnits().isEmpty()) {

      BoardService.printer("");
      BoardService.printer(("-----TURN " + turn + "-----"));

      BoardService.printer((System.lineSeparator() + home.getName() + "'s army"));
      displayArmy(home);

      BoardService.printer((System.lineSeparator() + away.getName() + "'s army"));
      displayArmy(away);

      battleMutualTurns(home, away, turn);

      turn++;

    }
    if (home.getUnits().isEmpty()) {
      BoardService.printer((away.getName() + " won"));
      record.setWinner("away");
    } else if (away.getUnits().isEmpty()) {
      BoardService.printer((home.getName() + " won"));
      record.setWinner("home");
    }

    record.setTurns(turn);

    return record;

  }

  /*
   * 
   * Battle Systems
   * 
   */

  private void battleMutualTurns(Emperor home, Emperor away, int turn) {
    combatSystem.fight(home, away);
    combatSystem.fight(away, home);
    if (turn == 1)
      combatSystem.fight(away, home);
  }

  private void battleIncrementingTurns(Emperor home, Emperor away, int turn) {
    if (turn % 2 == 1) {
      playTurns(home, away, turn);
      playTurns(away, home, turn);
    } else {
      playTurns(away, home, turn);
      playTurns(home, away, turn);
    }
  }

  private void playTurns(Emperor home, Emperor away, int turn) {
    for (int i = 0; i <= turn; i++) {

      combatSystem.fight(home, away);

    }
  }


  /*
   * 
   * 
   * 
   */

  public void displayArmy(Emperor emperor) {

    if (emperor.getUnits() != null && !emperor.getUnits().isEmpty()) {

      emperor.getUnits().forEach(u -> {

        // for (int i=1 ; i<= u.getGroup() ; i++) {
        BoardService.printer((unitNaming(u, String.valueOf(u.getGroup())) + "/HP:" + u.getHp()));
        // }

      });
    }


  }

  public static String unitNaming(Unit unit, String unitIndex) {

    return String.valueOf(unit.getOwner() + " " + unit.getUnitName() + "(" + unitIndex + "/"
        + String.valueOf(unit.getGroup()) + ")");

  }

  public void writeHistory(HistoricRecordDTO historicFacts) {

    producer.sendHistoricRecord(historicFacts);

  }

}
