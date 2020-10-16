package com.deathstar.Datahouse.service;

import java.io.IOException;

import com.deathstar.Datahouse.domain.mongo.BattleRecordMongo;
import com.deathstar.domain.BattleRecord;
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
	SparkService sparkService;
	
	@KafkaListener(topics = "TBU", groupId = "TBU")
	public void listen(BattleRecord record) throws IOException,ArrayStoreException {
	    System.out.println("Received Message in group TBU: " + record.toString());
		persistenceService.saveBattleRecord(fromMongo(record));
//	    history.saveSQLHistory(fromSQL(record));
//	    sparkService.startSparkCalculations();
	}

	private BattleRecordMongo fromMongo(BattleRecord dto) {

		BattleRecordMongo record = new BattleRecordMongo();
		record.setWinningSquad(dto.getWinningSquad());
		record.setLosingSquad(dto.getLosingSquad());
		record.setPostBattleSquad(dto.getPostBattleSquad());
		record.setStatPriority(dto.getStatPriority());
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
