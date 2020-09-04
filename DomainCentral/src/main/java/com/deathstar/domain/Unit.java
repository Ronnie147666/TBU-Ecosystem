package com.deathstar.domain;


public class Unit {

    private String unitName;
    private int hp;
    private int maxHp;
    private int pAtt;
    private int mAtt;
    private int pDef;
    private int mDef;
    private int heal;
    private int group;

    private String owner;

    public Unit(String unitName, int hp, int pAtt, int mAtt, int pDef, int mDef, int heal, int group) {
        super();
        this.unitName = unitName;
        this.hp = hp;
        this.pAtt = pAtt;
        this.mAtt = mAtt;
        this.pDef = pDef;
        this.mDef = mDef;
        this.heal = heal;
        this.group = group;
    }

    public Unit() {
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
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

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
