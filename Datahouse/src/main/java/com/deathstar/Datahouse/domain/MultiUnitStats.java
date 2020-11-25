package com.deathstar.Datahouse.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MultiUnitStats {


    private String name;
    private int winPoints;
    private int losePoints;
    private int participation;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWinPoints() { return winPoints; }

    public void setWinPoints(int winPoints) { this.winPoints = winPoints; }

    public int getLosePoints() { return losePoints; }

    public void setLosePoints(int losePoints) { this.losePoints = losePoints; }

    public int getScore() {
        return this.winPoints - this.losePoints;
    }

    public int getParticipation() {
        return participation;
    }

    public void setParticipation(int participation) {
        this.participation = participation;
    }

    public BigDecimal getPointsPerGame() {
        return BigDecimal.valueOf(((double) getScore() / this.participation)).setScale(2, RoundingMode.HALF_UP);
    }
}
