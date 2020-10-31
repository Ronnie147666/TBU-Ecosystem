//package com.deathstar.Datahouse.domain.sql;
//
//import java.io.Serializable;
//import java.time.LocalDate;
//import java.util.UUID;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import org.hibernate.annotations.Type;
//import org.hibernate.annotations.TypeDef;
//import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
//
//@Entity
//@Table(name = "battle_history",schema="tbu")
////@TypeDefs({
////  @TypeDef(name = "json", typeClass = JsonStringType.class),
//  @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
////})
//public class HistoricSQLRecord implements Serializable{
//
//  private static final long serialVersionUID = 1L;
//  
//  @Id
//  @GeneratedValue(generator = "system-uuid")
//  UUID id;
//  String homeEmperor;
//  String awayEmperor;
//  LocalDate dateCreated;
//  String winner;
//  String battleType;
//  int turns;
//
//  public HistoricSQLRecord() {
//    super();
//  }
//
//  public UUID getId() {
//    return id;
//  }
//
//  public void setId(UUID id) {
//    this.id = id;
//  }
//
//  @Type(type = "jsonb")
//  @Column(name = "home_emperor", columnDefinition = "jsonb")
//  public String getHomeEmperor() {
//    return homeEmperor;
//  }
//
//  public void setHomeEmperor(String homeEmperor) {
//    this.homeEmperor = homeEmperor;
//  }
//
//  @Type(type = "jsonb")
//  @Column(name = "away_emperor", columnDefinition = "jsonb")
//  public String getAwayEmperor() {
//    return awayEmperor;
//  }
//
//  public void setAwayEmperor(String awayEmperor) {
//    this.awayEmperor = awayEmperor;
//  }
//
//  @Column(name = "dateCreated")
//  public LocalDate getDateCreated() {
//    return dateCreated;
//  }
//
//  public void setDateCreated(LocalDate dateCreated) {
//    this.dateCreated = dateCreated;
//  }
//
//  @Column(name = "winner")
//  public String getWinner() {
//    return winner;
//  }
//
//  public void setWinner(String winner) {
//    this.winner = winner;
//  }
//
//  @Column(name = "turns")
//  public int getTurns() {
//    return turns;
//  }
//
//  public void setTurns(int turns) {
//    this.turns = turns;
//  }
//
//  @Column(name = "battletype")
//  public String getBattleType() {
//    return battleType;
//  }
//
//  public void setBattleType(String battleType) {
//    this.battleType = battleType;
//  }
//
//  @Override
//  public String toString() {
//    return "HistoricRecord [id=" + id + ", homeEmperor=" + homeEmperor + ", awayEmperor="
//        + awayEmperor + ", dateCreated=" + dateCreated + ", winner=" + winner + ", battleType="
//        + battleType + ", turns=" + turns + "]";
//  }
//
//
//}
