package com.deathstar.Datahouse.web;


import java.util.List;
import java.util.Map;

import com.deathstar.Datahouse.service.SparkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.deathstar.Datahouse.domain.mongo.HistoricMongoRecord;
import com.deathstar.Datahouse.domain.mongo.repository.HistoricMongoRepository;
import com.deathstar.Datahouse.domain.mongo.repository.reactive.MongoReactiveRepository;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("data")
public class WebController {

  @Autowired
  MongoReactiveRepository reactiveRepository;
  @Autowired
  HistoricMongoRepository repository;
  @Autowired
  SparkService sparkService;

  private final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

  @GetMapping("/battles")
  private Flux<HistoricMongoRecord> getBattlesReactive() {
    return reactiveRepository.findAll();
  }
  
  @GetMapping("/battles/normal")
  private List<HistoricMongoRecord> getBattles() {
    return repository.findAll();
  }

  @GetMapping("/percentages")
  private Map<String, Double> getUnitPercenatges() {
    return sparkService.getPercentagesMap();
  }

}
