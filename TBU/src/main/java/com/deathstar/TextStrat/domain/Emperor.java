package com.deathstar.TextStrat.domain;

import java.util.ArrayList;
import java.util.List;
import com.deathstar.domain.Unit;

public class Emperor {

	private String name;
	private int armySize;
	private List<Unit> units = new ArrayList<>();

	public Emperor() {
		super();
	}

	public Emperor(String name) {
		this.name = name;
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public int getArmySize() {
      return armySize;
    }
  
    public void setArmySize(int armySize) {
      this.armySize = armySize;
    }

}
