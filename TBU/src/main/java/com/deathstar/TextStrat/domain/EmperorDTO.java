package com.deathstar.TextStrat.domain;

import com.deathstar.domain.Unit;

import java.util.List;

public class EmperorDTO {

    String name;
    List<String> units;

    public EmperorDTO(String name, List<String> units) {
        this.name = name;
        this.units = units;
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
}

