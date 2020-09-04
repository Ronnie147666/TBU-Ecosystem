package com.deathstar.TextStrat.service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deathstar.domain.HistoricRecordDTO;

@Service
public class KafkaProducer {
	
	
	@Autowired
	private KafkaTemplate<String, HistoricRecordDTO> historicKafkaTemplate;
	
	public void sendHistoricRecord(HistoricRecordDTO record) {
		historicKafkaTemplate.send("TBU", record);
	}

}
