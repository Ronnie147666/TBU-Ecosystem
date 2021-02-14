package com.deathstar.Datahouse.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SingleUnitStats {
  
  
  private String name;
  private int wins;
  private int participation;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWins() {
    return wins;
  }

  public void setWins(int wins) {
    this.wins = wins;
  }

  public int getParticipation() {
    return participation;
  }

  public void setParticipation(int participation) {
    this.participation = participation;
  }

  public BigDecimal getPercentage() {
    return BigDecimal.valueOf(((double) this.wins / this.participation) * 100).setScale(2, RoundingMode.HALF_UP);
  }
}
