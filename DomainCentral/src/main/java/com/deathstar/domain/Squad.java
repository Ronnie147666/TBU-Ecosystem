package com.deathstar.domain;

public class Squad {

    private String squadName;
    private int health;
    private int maxHealth;
    private int physicalAtt;
    private int magicAtt;
    private int fireAtt;
    private int frostAtt;
    private int natureAtt;
    private int shadowAtt;
    private int physicalDef;
    private int magicDef;
    private int fireDef;
    private int frostDef;
    private int natureDef;
    private int shadowDef;
    private int heal;
    private int squadSize;
    private int squadHitRange;
    private boolean hasAttacked;
    private StatPriority statPriority;
    private Unit unit;

    private String owner;

    public Squad() {
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
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

    public boolean hasAttacked() {
        return hasAttacked;
    }

    public void setHasAttacked(boolean hasAttacked) {
        this.hasAttacked = hasAttacked;
    }

    public StatPriority getStatPriority() {
        return statPriority;
    }

    public void setStatPriority(StatPriority statPriority) {
        this.statPriority = statPriority;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
