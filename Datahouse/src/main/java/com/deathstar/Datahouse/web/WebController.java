package com.deathstar.Datahouse.web;


import java.util.List;
import java.util.Map;

import com.deathstar.Datahouse.domain.mongo.BattleRecordMongo;
import com.deathstar.Datahouse.service.SparkService;
import com.deathstar.domain.BattleRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.deathstar.Datahouse.domain.mongo.repository.BattleRecordRepository;
import com.deathstar.Datahouse.domain.mongo.repository.reactive.BattleRecordReactiveRepository;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("data")
public class WebController {

  @Autowired
  BattleRecordReactiveRepository reactiveRepository;
  @Autowired
  BattleRecordRepository repository;
  @Autowired
  SparkService sparkService;

  private final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

  @GetMapping("/battles")
  private Flux<BattleRecord> getBattlesReactive() {
    return reactiveRepository.findAll();
  }
  
  @GetMapping("/battles/normal")
  private List<BattleRecordMongo> getBattles() {
    return repository.findAll();
  }

//  @GetMapping("/percentages")
//  private Map<String, Double> getUnitPercentages() {
//    return sparkService.getPercentagesMap();
//  }

}
