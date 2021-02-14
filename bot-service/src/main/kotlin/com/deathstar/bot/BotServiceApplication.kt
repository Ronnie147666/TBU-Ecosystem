package com.deathstar.bot

import com.deathstar.bot.domain.SingleUnitStats
import com.deathstar.bot.service.StatsService
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
class BotLandApplication

fun main(args: Array<String>) {
//	runApplication<BotLandApplication>(*args)

	val ctx = SpringApplication.run(com.deathstar.bot.BotLandApplication::class.java, *args)

	val stats: StatsService = ctx.getBean(StatsService::class.java)
	val unitStats: Map<String, Map<String, Double>> = stats.getStats()
	val winRatios: List<SingleUnitStats> = stats.getWinRatio()

	print("qq")
}
