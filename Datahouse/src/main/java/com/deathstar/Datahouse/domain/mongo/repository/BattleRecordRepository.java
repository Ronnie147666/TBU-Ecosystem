package com.deathstar.Datahouse.domain.mongo.repository;

import com.deathstar.Datahouse.domain.mongo.BattleRecordMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BattleRecordRepository extends MongoRepository<BattleRecordMongo, String> {

}
