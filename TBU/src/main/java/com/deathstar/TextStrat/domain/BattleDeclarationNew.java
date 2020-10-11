package com.deathstar.TextStrat.domain;

import com.deathstar.domain.EmperorDTO;

public class BattleDeclarationNew {

    private EmperorDTO homeEmperor;
    private EmperorDTO awayEmperor;

    public BattleDeclarationNew(EmperorDTO homeEmperor, EmperorDTO awayEmperor) {
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
}
