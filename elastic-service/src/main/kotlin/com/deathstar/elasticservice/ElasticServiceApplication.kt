package com.deathstar.elasticservice

import com.deathstar.elasticservice.properties.NetworkProperties
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
class ElasticServiceApplication

fun main(args: Array<String>) {
	runApplication<ElasticServiceApplication>(*args)
}
