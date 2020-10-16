package com.deathstar.domain;

import java.util.ArrayList;
import java.util.List;
import com.deathstar.domain.Unit;

public class Emperor {

    private String name;
    private List<Squad> squads = new ArrayList<>();
    private int squadSize;
    private StatPriority statPriority;

    public Emperor() { }

    public Emperor(Emperor emperor) {
        this.name = emperor.getName();
        this.squads = emperor.getSquads();
        this.squadSize = emperor.getSquadSize();
        this.statPriority = emperor.getStatPriority();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Squad> getSquads() {
        return squads;
    }

    public void setSquads(List<Squad> squads) {
        this.squads = squads;
    }

    public int getSquadSize() {
        return squadSize;
    }

    public void setSquadSize(int squadSize) {
        this.squadSize = squadSize;
    }

    public StatPriority getStatPriority() { return statPriority; }

    public void setStatPriority(StatPriority statPriority) { this.statPriority = statPriority; }
}
