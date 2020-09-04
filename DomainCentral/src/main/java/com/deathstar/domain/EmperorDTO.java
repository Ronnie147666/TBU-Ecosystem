package com.deathstar.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;

@Entity
public class EmperorDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  String name;
  List<Unit> unitList;
  Map<String, Integer> units;
  
  public EmperorDTO() {
    super();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Map<String, Integer> getUnits() {
    return units;
  }

  public void setUnits(Map<String, Integer> units) {
    this.units = units;
  }

  public List<Unit> getUnitList() {
    return unitList;
  }

  public void setUnitList(List<Unit> unitList) {
    this.unitList = unitList;
  }

  @Override
  public String toString() {
    return "EmperorDTO [name=" + name + ", units=" + units + "]";
  }

}
