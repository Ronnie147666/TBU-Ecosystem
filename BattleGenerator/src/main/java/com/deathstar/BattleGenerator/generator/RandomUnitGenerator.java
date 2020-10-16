package com.deathstar.BattleGenerator.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomUnitGenerator {

    static Random random = new Random();

    static public String getRandomUnit() {
        return getUnit(getRandomNumber(37));
    }

    public static String getUnit(Integer unitNumber) {

        final Map<Integer, String> unitList = new HashMap<>();

        unitList.put(1, "Knight");
        unitList.put(2, "Berserker");
        unitList.put(3, "Ranger");
        unitList.put(4, "Dragon");
        unitList.put(5, "Archer");
        unitList.put(6, "Viking");
        unitList.put(7, "Mage");
        unitList.put(8, "Warlock");
        unitList.put(9, "Priest");
        unitList.put(10, "Shaman");
        unitList.put(11, "Swordmaster");
        unitList.put(12, "Paladin");
        unitList.put(13, "Lancer");
        unitList.put(14, "Cavalier");
        unitList.put(15, "Infernal");
        unitList.put(16, "Amazon");
        unitList.put(17, "Monk");
        unitList.put(18, "Druid");
        unitList.put(19, "Barbarian");
        unitList.put(20, "Shadowdancer");
        unitList.put(21, "Archmage");
        unitList.put(22, "Duelist");
        unitList.put(23, "Siren");
        unitList.put(24, "Templar");
        unitList.put(25, "Pirate");
        unitList.put(26, "Gladiator");
        unitList.put(27, "Demon");
        unitList.put(28, "Beastmaster");
        unitList.put(29, "Sorcerer");
        unitList.put(30, "Hellhound");
        unitList.put(31, "Warlord");
        unitList.put(32, "Inquisitor");
        unitList.put(33, "Witcher");
        unitList.put(34, "Stormlord");
        unitList.put(35, "WhiteMage");
        unitList.put(36, "Valkyrie");

        if (unitNumber == 0 || unitNumber > 36) {
            System.out.println(unitNumber);
        }

        return unitList.get(unitNumber);

    }

     public static Integer getRandomNumber(Integer bound) {
        return random.ints(1, bound).findFirst().getAsInt();
    }

}
