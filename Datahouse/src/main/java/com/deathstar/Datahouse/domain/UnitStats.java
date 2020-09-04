package com.deathstar.Datahouse.domain;

import java.math.BigDecimal;

public class UnitStats {
  
  
  private String name;
  private int wins;
  private int participations;
  private BigDecimal percentage;
  
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
  public int getParticipations() {
    return participations;
  }
  public void setParticipations(int participations) {
    this.participations = participations;
  }
  public BigDecimal getPercentage() {
    return percentage;
  }
  public void setPercentage(BigDecimal percentage) {
    this.percentage = percentage;
  }
  
}
