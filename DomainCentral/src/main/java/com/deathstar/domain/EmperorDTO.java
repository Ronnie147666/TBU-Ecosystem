package com.deathstar.domain;

import com.deathstar.domain.Unit;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class EmperorDTO {

    private String name;
    private List<String> units;
    private StatPriority statPriority;

    public EmperorDTO(String name, List<String> units, StatPriority statPriority) {
        this.name = name;
        this.units = units;
        this.statPriority = statPriority;
    }

    public EmperorDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUnits() {
        return units;
    }

    public void setUnits(List<String> units) {
        this.units = units;
    }

    public StatPriority getStatPriority() {
        return statPriority;
    }

    public void setStatPriority(StatPriority statPriority) {
        this.statPriority = statPriority;
    }

    @Override
    public String toString() {
        return "EmperorDTO{" +
                "name='" + name + '\'' +
                ", units=" + units +
                ", statPriority=" + statPriority +
                '}';
    }
}

