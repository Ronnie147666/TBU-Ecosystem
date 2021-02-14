package com.deathstar.BotLand.domain

import java.math.BigDecimal
import java.math.RoundingMode

class SingleUnitStats {
    var name: String? = null
    var wins = 0
    var participation = 0
    val percentage: BigDecimal
        get() = BigDecimal.valueOf(wins.toDouble() / participation * 100).setScale(2, RoundingMode.HALF_UP)
}