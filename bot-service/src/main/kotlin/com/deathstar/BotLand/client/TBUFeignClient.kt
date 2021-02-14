package com.deathstar.BotLand.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "TBU", url = "http://134.209.239.240:8010")
public interface TBUFeignClient {

    @RequestMapping(method = [RequestMethod.GET], value = ["tbu"])
    fun getUnitStats(): HashMap<String, Map<String, Double>>
}