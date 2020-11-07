package com.deathstar.domain;

import com.deathstar.domain.EmperorDTO;

public class BattleDeclaration {

    private EmperorDTO homeEmperor;
    private EmperorDTO awayEmperor;
    private BattleType battleType;

    public BattleDeclaration() {
    }

    public BattleDeclaration(EmperorDTO homeEmperor, EmperorDTO awayEmperor) {
        this.homeEmperor = homeEmperor;
        this.awayEmperor = awayEmperor;
    }

    public EmperorDTO getHomeEmperor() {
        return homeEmperor;
    }

    public void setHomeEmperor(EmperorDTO homeEmperor) {
        this.homeEmperor = homeEmperor;
    }

    public EmperorDTO getAwayEmperor() {
        return awayEmperor;
    }

    public void setAwayEmperor(EmperorDTO awayEmperor) {
        this.awayEmperor = awayEmperor;
    }

    public BattleType getBattleType() { return battleType; }

    public void setBattleType(BattleType battleType) { this.battleType = battleType; }

    @Override
    public String toString() {
        return "BattleDeclaration{" +
                "homeEmperor=" + homeEmperor +
                ", awayEmperor=" + awayEmperor +
                ", battleType=" + battleType +
                '}';
    }
}
