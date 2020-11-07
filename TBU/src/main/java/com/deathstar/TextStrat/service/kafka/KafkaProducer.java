package com.deathstar.TextStrat.service.kafka;

import com.deathstar.domain.BattleRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	
	
	@Autowired
	private KafkaTemplate<String, BattleRecord> kafkaTemplate;

	public void sendBattleRecord(BattleRecord record) {
		kafkaTemplate.send("TBU", record);
	}

}
