package com.deathstar.Datahouse.service;

import com.deathstar.Datahouse.domain.mongo.BattleRecordMongo;
import com.deathstar.domain.BattleRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deathstar.Datahouse.domain.mongo.repository.BattleRecordRepository;

@Service
public class PersistenceService {
	
	@Autowired
    BattleRecordRepository mongoRepository;
//	@Autowired
//	HistoricSQLRepository sqlRepository;
	
	public void saveBattleRecord(BattleRecordMongo record) {
		mongoRepository.save(record);
	}
	
//	public void saveSQLHistory(HistoricSQLRecord record) {
//	    sqlRepository.save(record);
//	}

}
