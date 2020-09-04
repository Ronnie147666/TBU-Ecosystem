package com.deathstar.TextStrat.service;

import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Service;
import com.deathstar.TextStrat.domain.UnitType;
import com.deathstar.domain.Unit;

@Service
public class ContentCreation {

	public Unit createUnit(String unitName, String unitCount, String emperorName) throws Exception {

		if (UnitType.valueOf(unitName) != null) {

			Unit unit = new Unit();

			UnitType type = UnitType.valueOf(unitName);

			unit.setHp((int) Math.round(type.getHp()*getRandomSeed(type.getModifier())));
			unit.setpAtt((int) Math.round(type.getpAtt()*getRandomSeed(type.getModifier())));
			unit.setpDef((int) Math.round(type.getpDef()*getRandomSeed(type.getModifier())));
			unit.setmAtt((int) Math.round(type.getmAtt()*getRandomSeed(type.getModifier())));
			unit.setmDef((int) Math.round(type.getmDef()*getRandomSeed(type.getModifier())));
			unit.setHeal((int) Math.round(type.getHeal()*getRandomSeed(type.getModifier())));
			unit.setGroup(type.getGroup());
			unit.setUnitName(type.getName()+" "+unitCount);

			unit.setMaxHp(unit.getHp());
			unit.setOwner(emperorName);
			
			return unit;
		} else {
			throw new Exception("No such unit exists!");
		}
	}
	
	private double getRandomSeed(double modifier) {
	  return ThreadLocalRandom.current().nextDouble(1, modifier);
	}

	
}
