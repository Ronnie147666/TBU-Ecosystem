package com.deathstar.TextStrat.config.kafka;

import java.util.HashMap;
import java.util.Map;

import com.deathstar.domain.BattleRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import com.deathstar.TextStrat.properties.NetworkProperties;
import com.deathstar.domain.HistoricRecordDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@EnableKafka
@Configuration
public class KafkaProducerConfig {
  
    @Autowired
    NetworkProperties networkProperties;

	ObjectMapper kafkaMapper = new ObjectMapper()
			.registerModule(new JavaTimeModule())
			.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false)
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
			.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
			.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
	
	
	@Bean
	public ProducerFactory<String, BattleRecord> producerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, networkProperties.getKafkaAddress());
		configProps.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, "100");
		configProps.put(ProducerConfig.RECONNECT_BACKOFF_MAX_MS_CONFIG, "50000");
		configProps.put(ProducerConfig.RECONNECT_BACKOFF_MS_CONFIG, "50000");
		return new DefaultKafkaProducerFactory<>(configProps, new StringSerializer(),
				new JsonSerializer<BattleRecord>(kafkaMapper));
	}

	@Bean
	public KafkaTemplate<String, BattleRecord> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}


}
