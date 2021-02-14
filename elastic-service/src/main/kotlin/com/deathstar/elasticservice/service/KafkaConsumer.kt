package com.deathstar.elasticservice.service

import com.deathstar.domain.BattleRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer {

    @KafkaListener(topics = ["TBU"], groupId = "TBU")
    fun listen(record: BattleRecord) {
        print(record)
    }
}