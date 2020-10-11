package com.deathstar.TextStrat.domain;

import java.time.LocalDate;

public class BattleRecord {

    Emperor homeEmperor;
    Emperor awayEmperor;

    LocalDate dateCreated;

    String winner;
    String battleType;
    int turns;

    public BattleRecord() {
    }

    public Emperor getHomeEmperor() {
        return homeEmperor;
    }

    public void setHomeEmperor(Emperor homeEmperor) {
        this.homeEmperor = homeEmperor;
    }

    public Emperor getAwayEmperor() {
        return awayEmperor;
    }

    public void setAwayEmperor(Emperor awayEmperor) {
        this.awayEmperor = awayEmperor;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getBattleType() {
        return battleType;
    }

    public void setBattleType(String battleType) {
        this.battleType = battleType;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }
}
