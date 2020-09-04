package com.deathstar.domain.Botland

sealed class Bot {
    class HealthBot: Bot()
    class WinrateBot: Bot()
    class DefenseBot: Bot()
    class AttackBot: Bot()
    class MagicBot: Bot()
}

fun getStatsMap(): Map<String, Map<String, Double>>? {
    return null
}