package com.deathstar.TextStrat.domain;

public enum UnitType {

				                       // HP -PATT-MATT-PDEF-MDEF-HEAL-GRP-MODIFIER

    Archmage			("Archmage",         1000,   0, 950,  20, 200, 100, 100, 100, 100, 100, 100,   0,  0,   0,  1, 2, 3.5),
    Assassin			("Assassin",          700, 150,  50, 200, 200, 100, 100, 100, 100, 100, 100,   0,  0,   0,  4, 2, 2.5),
    Banshee			    ("Banshee",           900, 300,  50, 200, 200, 100, 100, 100, 100, 100, 100,   0,  0,   0,  4, 2, 3.0),
    Berserker		    ("Berserker",        1250, 150,   0, 100,  50, 100, 100, 100, 100, 100, 100,   0,  0,   0,  5, 2, 3.5),
    Darkhorseman		("Dark Horseman",     250,   0, 150,   0,   0, 100, 100, 100, 100, 100, 100,   0,  0,   0, 15, 2, 2.0),
    Deathknight			("Death Knight",      150,   0, 750,  50, 500, 100, 100, 100, 100, 100, 100,   0,  0,   0, 15, 2, 2.0),
    Demonhunter			("Demon Hunter",      200,   0, 450,  30,  70, 100, 100, 100, 100, 100, 100,   0,  0,   0, 15, 2, 2.5),
    ElvenArcher			("Elven Archer",      250, 325,   0,  75,   0, 100, 100, 100, 100, 100, 100,   0,  0,   0, 10, 2, 2.5),
    Demon				("Demon",            2000,   0, 850, 300, 300, 100, 100, 100, 100, 100, 100,   0,  0,   0,  1, 2, 2.5),
    Dragon	   	        ("Dragon",           1000, 175,   0, 100,  50, 100, 100, 100, 100, 100, 100,   0,  0,   0,  5, 2, 2.5),
    Dryad				("Dryad",             300, 300,   0, 100, 100, 100, 100, 100, 100, 100, 100,   0,  0,   0, 15, 2, 2.0),
    Druid				("Druid",            1000, 100, 150, 150, 150, 100, 100, 100, 100, 100, 100,   0,  0, 200,  3, 2, 4.0),
    Gladiator			("Gladiator",        1000, 300,   0, 200,   0, 100, 100, 100, 100, 100, 100,   0,  0,   0,  5, 2, 3.0),
    Infernal			("Infernal",         2000,   0, 450, 200, 200, 100, 100, 100, 100, 100, 100,   0,  0,   0,  2, 2, 3.0),
    Knight		  		("Knight",           1000, 250,   0, 150,  25, 100, 100, 100, 100, 100, 100,   0,  0,   0,  5, 2, 3.5),
    Lich				("Lich",              200,   0, 450,  50, 400, 100, 100, 100, 100, 100, 100,   0,  0,   0, 10, 2, 2.5),
    Monk			 	("Monk",              500, 150, 150,  70,  70, 100, 100, 100, 100, 100, 100,   0,  0,  70, 10, 2, 3.5),
    Necromancer			("Necromancer",       500, 150, 150,  70,  70, 100, 100, 100, 100, 100, 100,   0,  0,  70, 10, 2, 3.5),
    Paladin	            ("Paladin",           500,   0, 100,  50,   0, 100, 100, 100, 100, 100, 100,   0,  0,   0, 10, 2, 3.0),
    Phoenix	  		    ("Phoenix",           550,   0, 300,  50, 200, 100, 100, 100, 100, 100, 100,   0,  0, 200,  5, 2, 3.0),
    Priest	  		    ("Priest",            550,   0, 300,  50, 200, 100, 100, 100, 100, 100, 100,   0,  0, 200,  5, 2, 3.0),
    Ranger		  		("Ranger",            875, 250,   0, 125,  75, 100, 100, 100, 100, 100, 100,   0,  0,   0,  5, 2, 2.5),
    Shadowdancer		("Shadowdancer",      400, 400,  50,  50,  50, 100, 100, 100, 100, 100, 100,   0,  0,   0, 10, 2, 2.5),
    Shaman	  		    ("Shaman",            550,   0, 350,  50, 200, 100, 100, 100, 100, 100, 100,   0,  0, 150,  5, 2, 3.0),
    Sorcerer			("Sorcerer",          200,   0, 250,  40,  40, 100, 100, 100, 100, 100, 100,   0,  0,   0, 15, 2, 2.0),
    Titan		    	("Titan",             200,   0, 250,  40,  40, 100, 100, 100, 100, 100, 100,   0,  0,   0, 15, 2, 2.0),
    Valkyrie			("Valkyrie",         1750, 500,   0, 250, 150, 100, 100, 100, 100, 100, 100,   0,  0,  50,  2, 2, 3.0),
    Viking 		        ("Viking",            350, 250,   0,  75,   0, 100, 100, 100, 100, 100, 100,   0,  0,   0, 10, 2, 2.5),
    Warlock	  		    ("Warlock",           350,   0, 800, 100, 225, 100, 100, 100, 100, 100, 100,   0,  0,   0,  3, 2, 2.5),
    Warrior				("Warrior",          1500, 400,   0, 400, 100, 100, 100, 100, 100, 100, 100,   0,  0,   0,  3, 2, 2.5),
    Wizard				("Wizard",           1500, 400,   0, 400, 100, 100, 100, 100, 100, 100, 100,   0,  0,   0,  3, 2, 2.5),
    Wraith				("Wraith",           1500, 400,   0, 400, 100, 100, 100, 100, 100, 100, 100,   0,  0,   0,  3, 2, 2.5),
    Wyvern				("Wyvern",           1300, 100, 250, 200, 200, 100, 100, 100, 100, 100, 100,   0,  0,   0,  7, 2, 2.0),

    FireElemental		("Fire Elemental",    300, 250, 150,  20,  20, 100, 100, 100, 100, 100, 100,   0,  0, 100, 10, 2, 3.0),
    FrostElemental		("Frost Elemental",   300, 250, 150,  20,  20, 100, 100, 100, 100, 100, 100,   0,  0, 100, 10, 2, 3.0),
    WindElemental		("Wind Elemental",    300, 250, 150,  20,  20, 100, 100, 100, 100, 100, 100,   0,  0, 100, 10, 2, 3.0),
    NatureElemental		("Nature Elemental",  300, 250, 150,  20,  20, 100, 100, 100, 100, 100, 100,   0,  0, 100, 10, 2, 3.0);


    private String name;
	private int health;

	private int physicalAtt;
    private int magicAtt;
    private int fireAtt;
    private int frostAtt;
    private int natureAtt;
    private int shadowAtt;
    private int physicalDef;

    // Percentage
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
