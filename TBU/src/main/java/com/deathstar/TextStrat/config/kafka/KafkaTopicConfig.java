package com.deathstar.TextStrat.config.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;
import com.deathstar.TextStrat.properties.NetworkProperties;

@Configuration
public class KafkaTopicConfig {
   
    @Autowired
    NetworkProperties networkProperties;
  
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, networkProperties.getKafkaAddress());
        return new KafkaAdmin(configs);
    }

}
