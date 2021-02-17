package com.deathstar.tbu.service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import com.deathstar.domain.EmperorDTO;
import com.deathstar.domain.Squad;
import org.springframework.stereotype.Service;
import com.deathstar.tbu.domain.UnitType;
import com.deathstar.domain.Unit;

@Service
public class UnitService {

    public Unit createUnit(String unitName, String emperorName) {

        Unit newUnit = new Unit();
        UnitType type = UnitType.valueOf(unitName);

        newUnit.setHealth((int) Math.round(type.getHealth() * getRandomSeed(type.getModifier())));
        newUnit.setPhysicalAtt((int) Math.round(type.getPhysicalAtt() * getRandomSeed(type.getModifier())));
        newUnit.setMagicAtt((int) Math.round(type.getMagicAtt() * getRandomSeed(type.getModifier())));
        newUnit.setFireAtt((int) Math.round(type.getFireAtt() * getRandomSeed(type.getModifier())));
        newUnit.setFrostAtt((int) Math.round(type.getFrostAtt() * getRandomSeed(type.getModifier())));
        newUnit.setNatureAtt((int) Math.round(type.getNatureAtt() * getRandomSeed(type.getModifier())));
        newUnit.setShadowAtt((int) Math.round(type.getShadowAtt() * getRandomSeed(type.getModifier())));
        newUnit.setPhysicalDef((int) Math.round(type.getPhysicalDef() * getRandomSeed(type.getModifier())));
        newUnit.setMagicDef((int) Math.round(type.getMagicDef() * getRandomSeed(type.getModifier())));
        newUnit.setFireDef((int) Math.round(type.getFireDef() * getRandomSeed(type.getModifier())));
        newUnit.setFrostDef((int) Math.round(type.getFrostDef() * getRandomSeed(type.getModifier())));
        newUnit.setNatureDef((int) Math.round(type.getNatureDef() * getRandomSeed(type.getModifier())));
        newUnit.setShadowDef((int) Math.round(type.getShadowDef() * getRandomSeed(type.getModifier())));
        newUnit.setHeal((int) Math.round(type.getHeal() * getRandomSeed(type.getModifier())));
        newUnit.setSquadSize(type.getSquadSize());
        newUnit.setSquadHitRange(type.getSquadHitRange());
        newUnit.setUnitName(type.getName());

        newUnit.setOwner(emperorName);

        return newUnit;
    }

    public Squad createSquad(Unit unit, int squadIndex) {

        Squad squad = new Squad();

        squad.setHealth(unit.getSquadSize() * unit.getHealth());
        squad.setMaxHealth(unit.getSquadSize() * unit.getHealth());
        squad.setPhysicalAtt(unit.getSquadSize() * unit.getPhysicalAtt());
        squad.setMagicAtt(unit.getSquadSize() * unit.getMagicAtt());
        squad.setFireAtt(unit.getSquadSize() * unit.getFireAtt());
        squad.setFrostAtt(unit.getSquadSize() * unit.getFrostAtt());
        squad.setNatureAtt(unit.getSquadSize() * unit.getNatureAtt());
        squad.setShadowAtt(unit.getSquadSize() * unit.getShadowAtt());
        squad.setPhysicalDef(unit.getPhysicalDef());
        squad.setMagicDef(unit.getMagicDef());
        squad.setFireDef(unit.getFireDef());
        squad.setFrostDef(unit.getFrostDef());
        squad.setNatureDef(unit.getNatureDef());
        squad.setShadowDef(unit.getShadowDef());
        squad.setHeal(unit.getSquadSize() * unit.getHeal());
        squad.setSquadSize(unit.getSquadSize());
        squad.setSquadHitRange(unit.getSquadHitRange());
        squad.setHasAttacked(false);
        squad.setOwner(unit.getOwner());
        squad.setUnit(unit);

        squad.setSquadName(unit.getUnitName() + " " + squadIndex);

        return squad;
    }


    private double getRandomSeed(double modifier) {
        return ThreadLocalRandom.current().nextDouble(0.5, modifier);
    }

    public HashMap<String, Map<String, Double>> getUnitStats() {

        HashMap<String, Map<String, Double>> units = new HashMap<>();

        Arrays.stream(UnitType.values()).forEach(u -> {

            Unit unit = createUnit(u.getName(), null);

            Map<String, Double> stats = new HashMap<>();
            stats.put("hp", (double) u.getHealth());
            stats.put("physicalAtt", (double) u.getPhysicalAtt());
            stats.put("magicalAtt", (double) u.getMagicAtt());
            stats.put("fireAtt", (double) u.getFireAtt());
            stats.put("frostAtt", (double) u.getFrostAtt());
            stats.put("natureAtt", (double) u.getNatureAtt());
            stats.put("shadowAtt", (double) u.getShadowAtt());
            stats.put("physicalDef", (double) u.getPhysicalDef());
            stats.put("magicalDef", (double) u.getMagicDef());
            stats.put("fireDef", (double) u.getFireDef());
            stats.put("frostDef", (double) u.getFrostDef());
            stats.put("natureDef", (double) u.getNatureDef());
            stats.put("shadowDef", (double) u.getShadowDef());
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

        AtomicInteger squadIndex = new AtomicInteger(1);

        emperorDTO.getUnits().forEach(u -> {
            try {
                squads.add(createSquad(createUnit(u, emperorDTO.getName()), squadIndex.getAndIncrement()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return squads;
    }

    static public Map<String, Comparator<Squad>> getStatComparator() {

        Map<String, Comparator<Squad>> statComparator= new HashMap<>();
        statComparator.put("health", Comparator.comparingInt(Squad::getHealth));
        statComparator.put("physicalAtt", Comparator.comparingInt(Squad::getPhysicalAtt));
        statComparator.put("magicAtt", Comparator.comparingInt(Squad::getMagicAtt));
        statComparator.put("physicalDef", Comparator.comparingInt(Squad::getPhysicalDef));
        statComparator.put("magicDef", Comparator.comparingInt(Squad::getMagicDef));
        statComparator.put("heal", Comparator.comparingInt(Squad::getHeal));
        statComparator.put("random", shuffle());

        return statComparator;
    }

    public static <T> Comparator<T> shuffle() {
        final Map<Object, UUID> uniqueIds = new IdentityHashMap<>();
        return Comparator.comparing(e -> uniqueIds.computeIfAbsent(e, k -> UUID.randomUUID()));
    }

}
