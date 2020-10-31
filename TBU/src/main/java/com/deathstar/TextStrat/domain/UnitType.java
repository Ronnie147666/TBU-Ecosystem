package com.deathstar.TextStrat.domain;

public enum UnitType {

				                       // HP -PATT-MATT-PDEF-MDEF-HEAL-GRP-MODIFIER
	
    Amazon				("Amazon",       300, 250, 150,  20,  20, 100, 10, 2,3.0),
    Archer		  		("Archer",       250, 325,   0,  75,   0,   0, 10, 2,2.5),
    Archmage			("Archmage",    1000,   0, 950,  20, 200,   0,  1, 2,3.5),
    Barbarian			("Barbarian",    700, 400,   0, 300,  50,   0,  5, 2,2.5),
    Beastmaster			("Beastmaster",  500, 180,  50, 100, 100,   0,  4, 2,4.0),
    Berserker		    ("Berserker",   1250, 150,   0, 100,  50,   0,  5, 2,3.5),
    Cavalier			("Cavalier",     250,   0, 150,   0,   0,   0, 15, 2,2.0),
    Demon				("Demon",       2000,   0, 850, 300, 300,   0,  1, 2,2.5),
    Dragon	   	        ("Ranger",      1000, 175,   0, 100,  50,   0,  5, 2,2.5),
    Druid				("Druid",       1000, 100, 150, 150, 150, 200,  3, 2,4.0),
    Duelist				("Duelist",      400, 300,   0,  50,  20,   0,  5, 2,3.5),
    Gladiator			("Gladiator",   1000, 300,   0, 200,   0,   0,  5, 2,3.0),
    Hellhound			("Hellhound",    900, 300,  50, 200, 200,   0,  4, 2,3.0),
    Infernal			("Infernal",    2000,   0, 450, 200, 200,   0,  2, 2,3.0),
    Inquisitor			("Inquisitor",   150,   0, 750,  50, 500,   0, 15, 2,2.0),
	Knight		  		("Knight",      1000, 250,   0, 150,  25,   0,  5, 2,3.5),
	Lancer				("Lancer",       300,   0, 100,   0,   0,   0, 15, 2,3.0),
	Mage		  		("Mage",         350,   0, 750,  50, 175,   0,  3, 2,3.5),
	Monk				("Monk",         500, 150, 150,  70,  70,  70, 10, 2,3.5),
	Paladin	            ("Paladin",      500,   0, 100,  50,   0,   0, 10, 2,3.0),
	Pirate				("Pirate",       300, 300,   0, 100, 100,   0, 15, 2,2.0),
	Priest	  		    ("Priest",       550,   0, 300,  50, 200, 200,  5, 2,3.0),
	Ranger		  		("Ranger",       875, 250,   0, 125,  75,   0,  5, 2,2.5),
	Shadowdancer		("Shadowdancer", 400, 400,  50,  50,  50,   0, 10, 2,2.5),
	Shaman	  		    ("Shaman",       550,   0, 350,  50, 200, 150,  5, 2,3.0),
	Siren				("Siren",        200,   0, 450,  50, 400,   0, 10, 2,2.5),
	Sorcerer			("Sorcerer",     200,   0, 250,  40,  40,   0, 15, 2,2.0),
	Stormlord			("Stormlord",   1300, 100, 250, 200, 200,   0,  7, 2,2.0),
	Swordmaster	       	("Swordmaster",  400,   0, 150,  25,  25,   0, 10, 2,2.0),
	Templar				("Templar",      700, 150,  50, 200, 200,   0,  4, 2,2.5),
	Valkyrie			("Valkyrie",    1750, 500,   0, 250, 150,  50,  2, 2,3.0),
	Viking 		        ("Viking",       350, 250,   0,  75,   0,   0, 10, 2,2.5),
	Warlock	  		    ("Warlock",      350,   0, 800, 100, 225,   0,  3, 2,2.5),
	Warlord				("Warlord",     1500, 400,   0, 400, 100,   0,  3, 2,2.5),
	WhiteMage			("White Mage",   200,   0, 450,  30,  70,   0, 15, 2,2.5),
	Witcher				("Witcher",     3000, 500, 500, 500, 500,   0,  1, 2,2.0);
	
	private String name;
	private int hp;
	private int pAtt;
	private int mAtt;
	private int pDef;
	private int mDef;
	private int heal;
	private int squadSize;
	private int squadHitRange;
	private double modifier;

	private UnitType(String name, int hp, int pAtt, int mAtt, int pDef, int mDef, int heal, int squadSize, int squadHitRange, double modifier) {
		this.name = name;
		this.hp = hp;
		this.pAtt = pAtt;
		this.mAtt = mAtt;
		this.pDef = pDef;
		this.mDef = mDef;
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

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getpAtt() {
		return pAtt;
	}

	public void setpAtt(int pAtt) {
		this.pAtt = pAtt;
	}

	public int getmAtt() {
		return mAtt;
	}

	public void setmAtt(int mAtt) {
		this.mAtt = mAtt;
	}

	public int getpDef() {
		return pDef;
	}

	public void setpDef(int pDef) {
		this.pDef = pDef;
	}

	public int getmDef() {
		return mDef;
	}

	public void setmDef(int mDef) {
		this.mDef = mDef;
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

	public int getSquadHitRange() { return squadHitRange; }

	public void setSquadHitRange(int squadHitRange) { this.squadHitRange = squadHitRange; }

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
