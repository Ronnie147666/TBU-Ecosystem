package com.deathstar.BotLand.service

import com.deathstar.BotLand.client.DataFeignClient
import com.deathstar.BotLand.client.TBUFeignClient
import com.deathstar.BotLand.domain.SingleUnitStats
import org.springframework.stereotype.Service

@Service
class StatsService(private val feignTBUClient: TBUFeignClient,
                   private val dataFeignClient: DataFeignClient){


    fun getStats(): Map<String, Map<String, Double>>{
        return feignTBUClient.getUnitStats()
    }

    fun getWinRatio(): List<SingleUnitStats> {
        return dataFeignClient.getUnitPercentages()
    }

}
