package com.deathstar.elasticservice.config

import com.deathstar.domain.BattleRecord
import com.deathstar.elasticservice.properties.NetworkProperties
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer
import java.util.*

@Configuration
@EnableConfigurationProperties(NetworkProperties::class)
class KafkaConsumerConfig(private val networkProperties: NetworkProperties) {

    fun consumerConfigs() = mapOf(
        ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to networkProperties.kafkaAddress,
        ConsumerConfig.GROUP_ID_CONFIG to "TBU",
        JsonDeserializer.TRUSTED_PACKAGES to "*"
    )


    @Bean
    fun consumerFactory(): ConsumerFactory<String, BattleRecord> {
        val deserializer: JsonDeserializer<BattleRecord> = JsonDeserializer(kafkaMapper)
        deserializer.configure(Collections.singletonMap((JsonDeserializer.TRUSTED_PACKAGES), "*"),  false)
        return DefaultKafkaConsumerFactory(consumerConfigs(), StringDeserializer(), deserializer)
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, BattleRecord> {
        val factory: ConcurrentKafkaListenerContainerFactory<String, BattleRecord> = ConcurrentKafkaListenerContainerFactory()
        factory.consumerFactory = consumerFactory()
        return factory
    }

    private val kafkaMapper: ObjectMapper = ObjectMapper()
//        .registerKotlinModule()
        .registerModule(JavaTimeModule())
        .configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
        .configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
        .configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false)

}