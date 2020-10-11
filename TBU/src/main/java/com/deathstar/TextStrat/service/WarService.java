package com.deathstar.TextStrat.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.deathstar.domain.BattleDeclarationNew;
import com.deathstar.domain.BattleDeclaration;
import com.deathstar.domain.BattleRecord;
import com.deathstar.domain.EmperorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.deathstar.domain.Emperor;
import com.deathstar.TextStrat.service.kafka.KafkaProducer;

@Service
public class WarService {

  @Autowired
  UnitService unitService;
  @Autowired
  BattleService battleService;
  @Autowired
  KafkaProducer producer;


  public BattleRecord createWar(BattleDeclarationNew battle) {
    Emperor home = prepareEmperor(battle.getHomeEmperor());
    Emperor away = prepareEmperor(battle.getAwayEmperor());

    BattleRecord record = new BattleRecord();

    record.setHomeEmperor(home);
    record.setAwayEmperor(away);

//    Map<String, String> battleResults = battleService.createBattle(home, away);

    record.setDateCreated(LocalDate.now());
//    record.setTurns(Integer.parseInt(battleResults.get("turns")));
    record.setBattleType(String.valueOf(home.getSquadSize()));
//    record.setWinner(battleResults.get("winner"));

    return record;
  }

  private Emperor prepareEmperor(EmperorDTO emperorDTO) {
    Emperor emperor = new Emperor();
    emperor.setSquads(unitService.prepareSquads(emperorDTO));
    emperor.setSquadSize(emperor.getSquads().size());
    return emperor;
  }
}
