package com.deathstar.Datahouse.domain.mongo.repository.reactive;

import com.deathstar.domain.BattleRecord;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleRecordReactiveRepository extends ReactiveMongoRepository<BattleRecord, String> {
}