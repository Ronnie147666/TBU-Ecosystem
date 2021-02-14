package com.deathstar.bot.service

import com.deathstar.bot.client.DataFeignClient
import com.deathstar.bot.client.TBUFeignClient
import com.deathstar.bot.domain.SingleUnitStats
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
