package com.deathstar.TextStrat.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("battle")
public class BattleConfiguration {

    private String battleType;

    public String getBattleType() {
      return battleType;
    }

    public void setBattleType(String battleType) {
      this.battleType = battleType;
    }

    
}
