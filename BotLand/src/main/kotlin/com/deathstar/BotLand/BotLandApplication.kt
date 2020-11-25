package com.deathstar.BotLand

import com.deathstar.BotLand.domain.SingleUnitStats
import com.deathstar.BotLand.service.StatsService
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
class BotLandApplication

fun main(args: Array<String>) {
//	runApplication<BotLandApplication>(*args)

	val ctx = SpringApplication.run(com.deathstar.BotLand.BotLandApplication::class.java, *args)

	val stats: StatsService = ctx.getBean(StatsService::class.java)
	val unitStats: Map<String, Map<String, Double>> = stats.getStats()
	val winRatios: List<SingleUnitStats> = stats.getWinRatio()

	print("qq")
}
