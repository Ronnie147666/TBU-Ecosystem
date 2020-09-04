package com.deathstar.Datahouse.domain.mongo.repository.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.deathstar.Datahouse.domain.mongo.HistoricMongoRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface MongoReactiveRepository extends ReactiveMongoRepository<HistoricMongoRecord, String> {
  
    Flux<HistoricMongoRecord> findAll();
    Mono<HistoricMongoRecord> findFirstByWinner(Mono<String> winner);
}