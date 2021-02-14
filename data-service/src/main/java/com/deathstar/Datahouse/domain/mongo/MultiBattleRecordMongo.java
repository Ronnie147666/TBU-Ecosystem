package com.deathstar.Datahouse.domain.mongo;

import com.deathstar.domain.BattleType;
import com.deathstar.domain.Squad;
import com.deathstar.domain.StatPriority;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;


@Document("multi_battle_record")
public class MultiBattleRecordMongo {

    @Id
    String id;
    List<String> winningSquad;
    List<String> losingSquad;
    List<Squad> postBattleSquad;

    StatPriority statPriority;
    LocalDate dateCreated;
    BattleType battleType;

    public MultiBattleRecordMongo() {
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
