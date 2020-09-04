package com.deathstar.domain;

import java.util.Map;

public class BattleDeclaration {

	String homeEmperor;
	Map<String, Integer> homeUnits;

	String awayEmperor;
	Map<String, Integer> awayUnits;

	
	
	public BattleDeclaration() {
		super();
	}

	public BattleDeclaration(String homeEmperor, Map<String, Integer> homeUnits, String awayEmperor,
			Map<String, Integer> awayUnits) {
		super();
		this.homeEmperor = homeEmperor;
		this.homeUnits = homeUnits;
		this.awayEmperor = awayEmperor;
		this.awayUnits = awayUnits;
	}

	public String getHomeEmperor() {
		return homeEmperor;
	}

	public void setHomeEmperor(String homeEmperor) {
		this.homeEmperor = homeEmperor;
	}

	public Map<String, Integer> getHomeUnits() {
		return homeUnits;
	}

	public void setHomeUnits(Map<String, Integer> homeUnits) {
		this.homeUnits = homeUnits;
	}

	public String getAwayEmperor() {
		return awayEmperor;
	}

	public void setAwayEmperor(String awayEmperor) {
		this.awayEmperor = awayEmperor;
	}

	public Map<String, Integer> getAwayUnits() {
		return awayUnits;
	}

	public void setAwayUnits(Map<String, Integer> awayUnits) {
		this.awayUnits = awayUnits;
	}

	@Override
	public String toString() {
		return "BattleDeclaration [homeEmperor=" + homeEmperor + ", homeUnits=" + homeUnits + ", awayEmperor="
				+ awayEmperor + ", awayUnits=" + awayUnits + "]";
	}
	
	

}
