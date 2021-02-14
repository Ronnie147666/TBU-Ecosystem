package com.deathstar.domain;

import java.time.LocalDate;
import java.util.List;

public class BattleResult {

    private String winner;
    private String loser;
    private List<Squad> winningSquad;
    private StatPriority winnerStatPriority;
    private StatPriority loserStatPriority;
    private BattleType battleType;
    private int turns;

    public BattleResult() {
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getLoser() {
        return loser;
    }

    public void setLoser(String loser) {
        this.loser = loser;
    }

    public List<Squad> getWinningSquad() {
        return winningSquad;
    }

    public void setWinningSquad(List<Squad> winningSquad) {
        this.winningSquad = winningSquad;
    }

    public StatPriority getWinnerStatPriority() {
        return winnerStatPriority;
    }

    public void setWinnerStatPriority(StatPriority winnerStatPriority) {
        this.winnerStatPriority = winnerStatPriority;
    }

    public StatPriority getLoserStatPriority() {
        return loserStatPriority;
    }

    public void setLoserStatPriority(StatPriority loserStatPriority) {
        this.loserStatPriority = loserStatPriority;
    }

    public BattleType getBattleType() {
        return battleType;
    }

    public void setBattleType(BattleType battleType) {
        this.battleType = battleType;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }
}
