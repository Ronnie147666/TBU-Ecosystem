package com.deathstar.domain;

import java.time.LocalDate;
import java.util.List;

public class BattleRecord {

    List<String> winningSquad;
    List<String> losingSquad;
    List<Squad> postBattleSquad;

    StatPriority statPriority;
    LocalDate dateCreated;
    BattleType battleType;

    public BattleRecord() {
    }

    public List<String> getWinningSquad() {
        return winningSquad;
    }

    public void setWinningSquad(List<String> winningSquad) {
        this.winningSquad = winningSquad;
    }

    public List<String> getLosingSquad() {
        return losingSquad;
    }

    public void setLosingSquad(List<String> losingSquad) {
        this.losingSquad = losingSquad;
    }

    public List<Squad> getPostBattleSquad() {
        return postBattleSquad;
    }

    public void setPostBattleSquad(List<Squad> postBattleSquad) {
        this.postBattleSquad = postBattleSquad;
    }

    public StatPriority getStatPriority() {
        return statPriority;
    }

    public void setStatPriority(StatPriority statPriority) {
        this.statPriority = statPriority;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public BattleType getBattleType() {
        return battleType;
    }

    public void setBattleType(BattleType battleType) {
        this.battleType = battleType;
    }
}
