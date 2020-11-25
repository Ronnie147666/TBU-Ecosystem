package com.deathstar.Datahouse.service;

import java.io.IOException;

import com.deathstar.Datahouse.domain.mongo.MultiBattleRecordMongo;
import com.deathstar.Datahouse.domain.mongo.SingleBattleRecordMongo;
import com.deathstar.domain.BattleRecord;
import com.deathstar.domain.BattleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
//import com.deathstar.Datahouse.domain.sql.HistoricSQLRecord;


@Service
//@Profile("kafka")
public class KafkaConsumer {
	
	@Autowired
	PersistenceService persistenceService;
	@Autowired
	StatsService sparkService;
	
	@KafkaListener(topics = "TBU", groupId = "TBU")
	public void listen(BattleRecord record) throws IOException,ArrayStoreException {
	    System.out.println("Received Message in group TBU: " + record.toString());
	    persistenceService.handleBattleRecord(record);
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
