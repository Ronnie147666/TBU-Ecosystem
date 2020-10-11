package com.deathstar.TextStrat.domain;

import java.util.ArrayList;
import java.util.List;
import com.deathstar.domain.Unit;

public class Emperor {

	private String name;
	private List<Squad> squads = new ArrayList<>();
	private int squadSize;

	public Emperor() { }

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
}
