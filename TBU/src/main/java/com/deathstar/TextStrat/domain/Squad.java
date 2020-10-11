package com.deathstar.TextStrat.domain;

public class Squad {

    private String squadName;
    private int hp;
    private int maxHp;
    private int physicalAtt;
    private int magicAtt;
    private int physicalDef;
    private int magicDef;
    private int heal;
    private int squadSize;
    private int squadHitRange;
    private boolean hasAttacked;

    private String owner;

    public Squad() {
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() { return maxHp; }

    public void setMaxHp(int maxHp) { this.maxHp = maxHp; }

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getSquadHitRange() { return squadHitRange; }

    public void setSquadHitRange(int squadHitRange) { this.squadHitRange = squadHitRange; }

    public boolean hasAttacked() { return hasAttacked; }

    public void setHasAttacked(boolean hasAttacked) { this.hasAttacked = hasAttacked; }
}
