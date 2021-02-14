package com.deathstar.Datahouse.service;

import com.deathstar.Datahouse.domain.mongo.MultiBattleRecordMongo;
import com.deathstar.Datahouse.domain.mongo.SingleBattleRecordMongo;
import com.deathstar.Datahouse.domain.mongo.repository.MultiBattleRecordRepository;
import com.deathstar.domain.BattleRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deathstar.Datahouse.domain.mongo.repository.SingleBattleRecordRepository;

@Service
public class PersistenceService {
	
	@Autowired
	SingleBattleRecordRepository singleBattleRepository;
	@Autowired
	MultiBattleRecordRepository multiBattleRepository;
//	@Autowired
//	HistoricSQLRepository sqlRepository;

	public void handleBattleRecord(BattleRecord record){
		switch (record.getBattleType()){
			case MULTI_FIVE:
			case MULTI_TEN:
			case MULTI_FIFTEEN:
				saveMultiBattleRecord(fromMongoMulti(record));
				break;
			case SINGLE_FIVE:
			case SINGLE_TEN:
			case SINGLE_FIFTEEN:
				saveSingleBattleRecord(fromMongoSingle(record));
				break;
		}

	}

	public void saveSingleBattleRecord(SingleBattleRecordMongo record) {
		singleBattleRepository.save(record);
	}

	public void saveMultiBattleRecord(MultiBattleRecordMongo record) {
		multiBattleRepository.save(record);
	}

	private SingleBattleRecordMongo fromMongoSingle(BattleRecord dto) {

		SingleBattleRecordMongo record = new SingleBattleRecordMongo();
		record.setWinningSquad(dto.getWinningSquad());
		record.setLosingSquad(dto.getLosingSquad());
		record.setPostBattleSquad(dto.getPostBattleSquad());
		record.setStatPriority(dto.getStatPriority());
		record.setDateCreated(dto.getDateCreated());
		record.setBattleType(dto.getBattleType());

		return record;
	}

	private MultiBattleRecordMongo fromMongoMulti(BattleRecord dto) {

		MultiBattleRecordMongo record = new MultiBattleRecordMongo();
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

//	public void saveSQLHistory(HistoricSQLRecord record) {
//	    sqlRepository.save(record);
//	}

}
