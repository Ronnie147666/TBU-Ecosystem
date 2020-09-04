package com.deathstar.Datahouse.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.deathstar.Datahouse.domain.mongo.HistoricMongoRecord;
//import com.deathstar.Datahouse.domain.sql.HistoricSQLRecord;
import com.deathstar.domain.HistoricRecordDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
//@Profile("kafka")
public class KafkaConsumer {
	
	@Autowired
	StoreHistory history;
	@Autowired
	SparkService sparkService;
	
	@KafkaListener(topics = "TBU", groupId = "TBU")
	public void listenHistory(HistoricRecordDTO record) throws IOException,ArrayStoreException {
	    System.out.println("Received Message in group TBU: " + record.toString());
	    history.saveMongoHistory(fromMongo(record));
//	    history.saveSQLHistory(fromSQL(record));
	    sparkService.startSpark();
	}

	private HistoricMongoRecord fromMongo(HistoricRecordDTO dto) {
		
		HistoricMongoRecord record = new HistoricMongoRecord();
		record.setHomeEmperor(dto.getHomeEmperor());
		record.setAwayEmperor(dto.getAwayEmperor());
		record.setTurns(dto.getTurns());
		record.setWinner(dto.getWinner());
		record.setDateCreated(dto.getDateCreated());
		record.setBattleType(dto.getBattleType());
		
		return record;
		
		
	}
	
//	private HistoricSQLRecord fromSQL(HistoricRecordDTO dto) throws JsonProcessingException {
//	  
//	  ObjectMapper om = new ObjectMapper();	  
//	  HistoricSQLRecord record = new HistoricSQLRecord();
//	  record.setHomeEmperor(om.writeValueAsString(dto.getHomeEmperor()));
//	  record.setAwayEmperor(om.writeValueAsString(dto.getAwayEmperor()));
//	  record.setTurns(dto.getTurns());
//	  record.setWinner(dto.getWinner());
//	  record.setDateCreated(dto.getDateCreated());
//	  record.setBattleType(dto.getBattleType());
//	  
//	  return record;
//	  
//	  
//	}
	
}
