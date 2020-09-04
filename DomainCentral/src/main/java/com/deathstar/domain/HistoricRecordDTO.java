package com.deathstar.domain;

import java.time.LocalDate;

public class HistoricRecordDTO {

	EmperorDTO homeEmperor;
	EmperorDTO awayEmperor;
	
	LocalDate dateCreated;
	
	String winner;
	String battleType;
	int turns;
	
	public HistoricRecordDTO() {
		super();
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

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}

    public String getBattleType() {
      return battleType;
    }
  
    public void setBattleType(String battleType) {
      this.battleType = battleType;
    }

    @Override
    public String toString() {
      return "HistoricRecordDTO [homeEmperor=" + homeEmperor + ", awayEmperor=" + awayEmperor
          + ", dateCreated=" + dateCreated + ", winner=" + winner + ", battleType=" + battleType
          + ", turns=" + turns + "]";
    }


	
}
