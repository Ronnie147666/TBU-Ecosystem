package com.deathstar.elasticservice.service

import com.deathstar.domain.BattleRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class KafkaConsumer(private val elasticsearchService: ElasticsearchService) {

    @KafkaListener(topics = ["TBU"], groupId = "TBU")
    fun consumeForElastic(record: BattleRecord) {
        elasticsearchService.create(
            "battle_records_" + LocalDate.now().dayOfMonth + "_" + LocalDate.now().monthValue,
            record
        )
    }
}