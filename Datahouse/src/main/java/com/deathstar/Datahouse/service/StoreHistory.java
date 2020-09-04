package com.deathstar.Datahouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deathstar.Datahouse.domain.mongo.HistoricMongoRecord;
import com.deathstar.Datahouse.domain.mongo.repository.HistoricMongoRepository;
//import com.deathstar.Datahouse.domain.sql.HistoricSQLRecord;
//import com.deathstar.Datahouse.domain.sql.repository.HistoricSQLRepository;

@Service
public class StoreHistory {
	
	@Autowired
	HistoricMongoRepository mongoRepository;
//	@Autowired
//	HistoricSQLRepository sqlRepository;
	
	public void saveMongoHistory(HistoricMongoRecord record) {
		mongoRepository.save(record);
	}
	
//	public void saveSQLHistory(HistoricSQLRecord record) {
//	    sqlRepository.save(record);
//	}

}
