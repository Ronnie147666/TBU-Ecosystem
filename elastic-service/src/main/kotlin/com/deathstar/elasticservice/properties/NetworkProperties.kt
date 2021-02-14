package com.deathstar.elasticservice.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties("network")
data class NetworkProperties (
   var kafkaAddress: List<String> = mutableListOf()
   )
