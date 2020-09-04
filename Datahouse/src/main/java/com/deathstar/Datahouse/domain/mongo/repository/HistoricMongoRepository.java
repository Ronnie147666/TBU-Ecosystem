package com.deathstar.Datahouse.domain.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.deathstar.Datahouse.domain.mongo.HistoricMongoRecord;

public interface HistoricMongoRepository extends MongoRepository<HistoricMongoRecord, String> {

}
