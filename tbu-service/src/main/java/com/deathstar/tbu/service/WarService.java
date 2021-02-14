package com.deathstar.tbu.service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.deathstar.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deathstar.tbu.service.kafka.KafkaProducer;

@Service
public class WarService {

  @Autowired
  UnitService unitService;
  @Autowired
  BattleService battleService;
  @Autowired
  KafkaProducer producer;

  private final Logger LOGGER = LoggerFactory.getLogger(WarService.class);

  public BattleRecord createWar(BattleDeclaration battle) {

    LOGGER.info("Received battle: " + battle.toString());

    Emperor home = prepareEmperor(battle.getHomeEmperor());
    Emperor away = prepareEmperor(battle.getAwayEmperor());

    BattleRecord record = new BattleRecord();

    Map<String, List<String>> preBattleSquads = getPreBattleSquads(home, away);

    BattleResult battleResult = battleService.createBattle(home, away);

    record.setDateCreated(LocalDate.now());
    record.setBattleType(battle.getBattleType());
    record.setWinningSquad(preBattleSquads.get(battleResult.getWinner()));
    record.setLosingSquad(preBattleSquads.get(battleResult.getLoser()));
    record.setPostBattleSquad(battleResult.getWinningSquad());
    record.setStatPriority(battleResult.getWinnerStatPriority());

    LOGGER.info("Finished battle");

    producer.sendBattleRecord(record);

    return record;
  }

  private Map<String, List<String>> getPreBattleSquads(Emperor home, Emperor away) {
    List<String> homeSquads = home.getSquads().stream().map( s -> s.getUnit().getUnitName()).collect(Collectors.toList());
    List<String> awaySquads = away.getSquads().stream().map( s -> s.getUnit().getUnitName()).collect(Collectors.toList());
    return Stream.of(
            new AbstractMap.SimpleImmutableEntry<>("home", homeSquads),
            new AbstractMap.SimpleImmutableEntry<>("away", awaySquads)).collect(Collectors.collectingAndThen(
            Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue),
            Collections::<String, List<String>> unmodifiableMap));
  }

  private Emperor prepareEmperor(EmperorDTO emperorDTO) {
    Emperor emperor = new Emperor();
    emperor.setName(emperorDTO.getName());
    emperor.setSquads(unitService.prepareSquads(emperorDTO));
    emperor.setSquadSize(emperor.getSquads().size());
    return emperor;
  }
}
