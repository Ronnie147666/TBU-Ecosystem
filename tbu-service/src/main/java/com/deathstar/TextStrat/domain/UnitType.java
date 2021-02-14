package com.deathstar.TextStrat.domain;

public enum UnitType {

				                       // HP -PATT-MATT-PDEF-MDEF-HEAL-GRP-MODIFIER

    Archmage			("Archmage",          700,   0, 500, 200, 200,   0,   0,   0,  90,  30,  40,   0, 60,   0,  1, 1, 1.0),
    Assassin			("Assassin",         1000, 600,   0,   0,   0, 200, 150,  30,  10,   0,   0,  60, 40,   0,  1, 1, 1.0),
    Banshee			    ("Banshee",           900,   0, 250,   0,   0,  50, 250,   0,  60,   0,   0,   0, 55,   0,  5, 4, 1.0),
    Berserker		    ("Berserker",        1250, 350,   0,  50,   0,   0,   0,  60,   0,  20,   0,   0,  0,   0, 10, 4, 1.0),
    Darkhorseman		("Dark Horseman",    1350, 200,   0,   0,  50,   0, 250,  40,  10,   0,  20,   0, 50,   0,  4, 4, 1.0),
    Deathknight			("Death Knight",     1500, 200,   0,   0, 100,   0, 300,  50,  10,   0,  20,   0, 65,   0,  9, 3, 1.0),
    Demonhunter			("Demon Hunter",     1000, 200,   0,  50,  70,   0, 200,  10,  15,  20,   0,   0, 30,   0,  5, 1, 1.0),
    ElvenArcher			("Elven Archer",      500, 125,   0,   0,   0, 100,   0,   5,  10,   0,   0,  80,  0,   0, 10, 5, 1.0),
    Demon				("Demon",            1700,   0, 100, 450,   0,   0, 350,  10,  20,  65,   0,   0, 70,   0,  5, 6, 1.0),
    Dragon	   	        ("Dragon",           3500, 250,   0, 500,   0,   0,   0,  80,  50,  85,  10,   0,  5,   0,  1,10, 1.0),
    Dryad				("Dryad",             600, 300,   0,   0,   0, 100,   0,  40,  15,   0,   0,  50,  0,   0, 10, 2, 1.0),
    Druid				("Druid",            1000,   0,   0,   0,   0, 400,   0,  15,  20,   0,   0,  90,  0, 200,  5, 3, 1.0),
    Gladiator			("Gladiator",        1250, 350,   0,  50,   0,   0,   0,  65,   0,  10,   0,   0,  0,   0, 10, 1, 1.0),
    Infernal			("Infernal",         4000, 300,   0, 150,   0,   0, 200,  90,  70,  90,  70,   0, 55,   0,  1,10, 1.0),
    Knight		  		("Knight",           1500, 450,   0,   0,   0,   0,   0,  70,   0,  25,  25,   0,  0,   0, 10, 1, 1.0),
    Lich				("Lich",             1000,   0, 300,   0, 200,   0, 200,   0,  90,   0, 100,   0, 70,   0,  1, 3, 1.0),
    Monk			 	("Monk",             1000, 150,   0,   0,   0, 100,   0,  15,  10,   0,   0,  20,  0,   0,  5, 2, 1.0),
    Necromancer			("Necromancer",       500,   0, 400,   0,   0,   0, 500,   0,  65,   5,   0,   0, 70,   0,  5, 6, 1.0),
    Paladin	            ("Paladin",          1900, 200, 100,   0,   0,   0,   0,  55,  25,   0,  15,   0,  0,   0,  5, 2, 1.0),
    Phoenix	  		    ("Phoenix",          2500,   0, 300, 250,   0,   0,   0,   0,  45, 100,   0,   0,  0, 400,  1, 8, 1.0),
    Priest	  		    ("Priest",            500,   0, 100,   0,   0,   0,   0,   0,  45,   0,   0,   0, 30, 600,  5, 8, 1.0),
    Ranger		  		("Ranger",           1350, 250,   0,   0,   0, 300,   0,  25,   0,   0,   0,  70,  0,   0,  5, 1, 1.0),
    Shadowdancer		("Shadowdancer",      800, 300,  50,   0,   0,   0, 360,  10,   5,   0,   0,   0, 80,   0,  2, 1, 1.0),
    Shaman	  		    ("Shaman",           1050,   0, 150, 150,   0, 250,   0,  10,   5,  25,   5,  70,  0, 150,  5, 5, 1.0),
    Sorcerer			("Sorcerer",          600,   0, 250, 100, 100,   0,   0,   0,  80,  40,  20,  20,  0,   0, 10, 4, 1.0),
    Titan		    	("Titan",            5000, 300,   0,   0, 200,   0,   0,  90,  60,  75, 100,   0,  0,   0,  1,12, 1.0),
    Valkyrie			("Valkyrie",         2000, 400,   0,  50,   0,   0,   0,  65,   0,  15,  30,   0,  0,  50,  5, 2, 1.0),
    Viking 		        ("Viking",           1750, 450,   0,   0, 250,   0,   0,  65,   0,  10,  90,   0,  0,   0, 10, 1, 1.0),
    Warlock	  		    ("Warlock",           750,   0, 400, 250,   0, 100, 180,   0,  65,  55,   0,  40, 65,   0,  3, 3, 1.0),
    Warrior				("Warrior",          1500, 400,   0, 100,   0,   0,   0,  70,   0,  30,  25,   0,  0,   0,  5, 2, 1.0),
    Wizard				("Wizard",           1000,   0, 600, 100, 100,   0, 200,   0, 100,  10,  35,  10, 30,   0,  1, 7, 1.0),
    Wraith				("Wraith",           1000,   0, 150,   0,   0,   0, 250, 100,  30,   0,   0,   0, 90,   0,  5, 2, 1.0),
    Wyvern				("Wyvern",           3000, 150,   0,   0,   0, 200,   0,  70,  20,  45,  10,   0,  0,   0,  1,10, 1.0),

    FireElemental		("Fire Elemental",   1500,  50, 150,  250,  0,   0,   0, 20, 40, 80,  0,   0,  0, 0, 5, 5, 1.0),
    FrostElemental		("Frost Elemental",  1500,  50, 150,    0,250,   0,   0, 20, 40,  0, 80,   0,  0, 0, 5, 5, 1.0),
    NatureElemental		("Nature Elemental", 1500,  50, 150,    0,  0, 250,   0, 20, 40,  0,  0,  80,  0, 0, 5, 5, 1.0),
    ShadowElemental		("Shadow Elemental", 1500,  50, 150,    0,  0,   0, 250, 20, 40,  0,  0,   0, 80, 0, 5, 5, 1.0);

    private String name;
	private int health;

	private int physicalAtt;
    private int magicAtt;
    private int fireAtt;
    private int frostAtt;
    private int natureAtt;
    private int shadowAtt;

    // Percentage
    private int physicalDef;
    private int magicDef;
	private int fireDef;
    private int frostDef;
    private int natureDef;
    private int shadowDef;

    private int heal;

	private int squadSize;
	private int squadHitRange;
	private double modifier;

    UnitType(String name, int health, int physicalAtt, int magicAtt, int fireAtt, int frostAtt, int natureAtt, int shadowAtt,
             int physicalDef, int magicDef, int fireDef, int frostDef, int natureDef, int shadowDef, int heal, int squadSize, int squadHitRange, double modifier) {
        this.name = name;
        this.health = health;
        this.physicalAtt = physicalAtt;
        this.magicAtt = magicAtt;
        this.fireAtt = fireAtt;
        this.frostAtt = frostAtt;
        this.natureAtt = natureAtt;
        this.shadowAtt = shadowAtt;
        this.physicalDef = physicalDef;
        this.magicDef = magicDef;
        this.fireDef = fireDef;
        this.frostDef = frostDef;
        this.natureDef = natureDef;
        this.shadowDef = shadowDef;
        this.heal = heal;
        this.squadSize = squadSize;
        this.squadHitRange = squadHitRange;
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPhysicalAtt() {
        return physicalAtt;
    }

    public void setPhysicalAtt(int physicalAtt) {
        this.physicalAtt = physicalAtt;
    }

    public int getMagicAtt() {
        return magicAtt;
    }

    public void setMagicAtt(int magicAtt) {
        this.magicAtt = magicAtt;
    }

    public int getFireAtt() {
        return fireAtt;
    }

    public void setFireAtt(int fireAtt) {
        this.fireAtt = fireAtt;
    }

    public int getFrostAtt() {
        return frostAtt;
    }

    public void setFrostAtt(int frostAtt) {
        this.frostAtt = frostAtt;
    }

    public int getNatureAtt() {
        return natureAtt;
    }

    public void setNatureAtt(int natureAtt) {
        this.natureAtt = natureAtt;
    }

    public int getShadowAtt() {
        return shadowAtt;
    }

    public void setShadowAtt(int shadowAtt) {
        this.shadowAtt = shadowAtt;
    }

    public int getPhysicalDef() {
        return physicalDef;
    }

    public void setPhysicalDef(int physicalDef) {
        this.physicalDef = physicalDef;
    }

    public int getMagicDef() {
        return magicDef;
    }

    public void setMagicDef(int magicDef) {
        this.magicDef = magicDef;
    }

    public int getFireDef() {
        return fireDef;
    }

    public void setFireDef(int fireDef) {
        this.fireDef = fireDef;
    }

    public int getFrostDef() {
        return frostDef;
    }

    public void setFrostDef(int frostDef) {
        this.frostDef = frostDef;
    }

    public int getNatureDef() {
        return natureDef;
    }

    public void setNatureDef(int natureDef) {
        this.natureDef = natureDef;
    }

    public int getShadowDef() {
        return shadowDef;
    }

    public void setShadowDef(int shadowDef) {
        this.shadowDef = shadowDef;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getSquadSize() {
        return squadSize;
    }

    public void setSquadSize(int squadSize) {
        this.squadSize = squadSize;
    }

    public int getSquadHitRange() {
        return squadHitRange;
    }

    public void setSquadHitRange(int squadHitRange) {
        this.squadHitRange = squadHitRange;
    }

    public double getModifier() {
        return modifier;
    }

    public void setModifier(double modifier) {
        this.modifier = modifier;
    }

    public static boolean contains(String unitName) {

        for (UnitType t : UnitType.values()) {
            if (t.name().equals(unitName)) {
                return true;
            }
        }

        return false;
    }
}
