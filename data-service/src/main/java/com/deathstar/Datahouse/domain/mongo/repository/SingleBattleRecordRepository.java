package com.deathstar.Datahouse.domain.mongo.repository;

import com.deathstar.Datahouse.domain.mongo.SingleBattleRecordMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SingleBattleRecordRepository extends MongoRepository<SingleBattleRecordMongo, String> {

}
