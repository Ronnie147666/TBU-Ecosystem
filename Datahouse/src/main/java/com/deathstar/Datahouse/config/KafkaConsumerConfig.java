package com.deathstar.Datahouse.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.deathstar.domain.BattleRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import com.deathstar.Datahouse.properties.NetworkProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Autowired
    NetworkProperties networkProperties;
  
	@Bean
	public ConsumerFactory<String, BattleRecord> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
		JsonDeserializer<BattleRecord> deserializer = new JsonDeserializer<>(kafkaMapper);
		deserializer.configure(Collections.singletonMap(JsonDeserializer.TRUSTED_PACKAGES, "*"), false);
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, networkProperties.getKafkaAddress());
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "TBU");
		props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, BattleRecord> kafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, BattleRecord> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
	ObjectMapper kafkaMapper = new ObjectMapper()
			.registerModule(new JavaTimeModule())
			.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false)
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
			.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
			.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
	
}
