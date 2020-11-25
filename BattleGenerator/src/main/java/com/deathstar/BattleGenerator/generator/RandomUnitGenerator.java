package com.deathstar.BattleGenerator.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomUnitGenerator {

    static Random random = new Random();

    static public String getRandomUnit() {
        return getUnit(getRandomNumber(38));
    }

    public static String getUnit(Integer unitNumber) {

        final Map<Integer, String> unitList = new HashMap<>();

        unitList.put(1, "Archmage");
        unitList.put(2, "Assassin");
        unitList.put(3, "Banshee");
        unitList.put(4, "Berserker");
        unitList.put(5, "Darkhorseman");
        unitList.put(6, "Deathknight");
        unitList.put(7, "Demonhunter");
        unitList.put(8, "ElvenArcher");
        unitList.put(9, "Demon");
        unitList.put(10, "Dragon");
        unitList.put(11, "Dryad");
        unitList.put(12, "Druid");
        unitList.put(13, "Gladiator");
        unitList.put(14, "Infernal");
        unitList.put(15, "Knight");
        unitList.put(16, "Lich");
        unitList.put(17, "Monk");
        unitList.put(18, "Necromancer");
        unitList.put(19, "Paladin");
        unitList.put(20, "Phoenix");
        unitList.put(21, "Priest");
        unitList.put(22, "Ranger");
        unitList.put(23, "Shadowdancer");
        unitList.put(24, "Shaman");
        unitList.put(25, "Sorcerer");
        unitList.put(26, "Titan");
        unitList.put(27, "Valkyrie");
        unitList.put(28, "Viking");
        unitList.put(29, "Warlock");
        unitList.put(30, "Warrior");
        unitList.put(31, "Wizard");
        unitList.put(32, "Wraith");
        unitList.put(33, "Wyvern");
        unitList.put(34, "FireElemental");
        unitList.put(35, "FrostElemental");
        unitList.put(36, "NatureElemental");
        unitList.put(37, "ShadowElemental");

        if (unitNumber == 0 || unitNumber > 37) {
            System.out.println(unitNumber);
        }

        return unitList.get(unitNumber);

    }

     public static Integer getRandomNumber(Integer bound) {
        return random.ints(1, bound).findFirst().getAsInt();
    }

}
