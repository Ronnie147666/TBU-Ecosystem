package com.deathstar.TextStrat.service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import com.deathstar.domain.EmperorDTO;
import com.deathstar.domain.Squad;
import org.springframework.stereotype.Service;
import com.deathstar.TextStrat.domain.UnitType;
import com.deathstar.domain.Unit;

@Service
public class UnitService {

    public Unit createUnit(String unitName, String emperorName) {

        Unit newUnit = new Unit();
        UnitType type = UnitType.valueOf(unitName);

        newUnit.setHp((int) Math.round(type.getHp() * getRandomSeed(type.getModifier())));
        newUnit.setPhysicalAtt((int) Math.round(type.getpAtt() * getRandomSeed(type.getModifier())));
        newUnit.setPhysicalDef((int) Math.round(type.getpDef() * getRandomSeed(type.getModifier())));
        newUnit.setMagicAtt((int) Math.round(type.getmAtt() * getRandomSeed(type.getModifier())));
        newUnit.setMagicDef((int) Math.round(type.getmDef() * getRandomSeed(type.getModifier())));
        newUnit.setHeal((int) Math.round(type.getHeal() * getRandomSeed(type.getModifier())));
        newUnit.setSquadSize(type.getSquadSize());
        newUnit.setSquadHitRange(type.getSquadHitRange());
        newUnit.setUnitName(type.getName());

        newUnit.setOwner(emperorName);

        return newUnit;
    }

    public Squad createSquad(Unit unit, int squadIndex) {

        Squad squad = new Squad();

        squad.setHp(unit.getSquadSize() * unit.getHp());
        squad.setPhysicalAtt(unit.getSquadSize() * unit.getPhysicalAtt());
        squad.setMagicAtt(unit.getSquadSize() * unit.getMagicAtt());
        squad.setPhysicalDef(unit.getPhysicalDef());
        squad.setMagicDef(unit.getMagicDef());
        squad.setHeal(unit.getSquadSize() * unit.getHeal());
        squad.setOwner(unit.getOwner());

        squad.setSquadName(unit.getUnitName() + " " + squadIndex);

        return squad;
    }


    private double getRandomSeed(double modifier) {
        return ThreadLocalRandom.current().nextDouble(1, modifier);
    }

    public HashMap<String, Map<String, Double>> getUnitStats() {

        HashMap<String, Map<String, Double>> units = new HashMap<>();

        Arrays.stream(UnitType.values()).forEach(u -> {

            Map<String, Double> stats = new HashMap<>();
            stats.put("hp", (double) u.getHp());
            stats.put("pAtt", (double) u.getpAtt());
            stats.put("mAtt", (double) u.getmAtt());
            stats.put("pDef", (double) u.getpDef());
            stats.put("mDef", (double) u.getmDef());
            stats.put("heal", (double) u.getHeal());
            stats.put("squadSize", (double) u.getSquadSize());
            stats.put("squadHitRange", (double) u.getSquadHitRange());
            stats.put("modifier", u.getModifier());

            units.put(u.name(), stats);
        });

        return units;
    }

    public List<Squad> prepareSquads(EmperorDTO emperorDTO) {
        List<Squad> squads = new ArrayList<>();

        AtomicInteger squadIndex = new AtomicInteger();

        emperorDTO.getUnits().forEach(u -> {
            try {
                squads.add(createSquad(createUnit(u, emperorDTO.getName()), squadIndex.getAndIncrement()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return squads;
    }
}
