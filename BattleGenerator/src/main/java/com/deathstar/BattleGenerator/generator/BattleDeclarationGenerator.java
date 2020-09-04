package com.deathstar.BattleGenerator.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.deathstar.BattleGenerator.client.FeignTBUClient;
import com.deathstar.domain.BattleDeclaration;

@Service
public class BattleDeclarationGenerator {

  Random random = new Random();

  final List<Integer> battleMode = Arrays.asList(5, 10, 15);
  
  @Autowired
  FeignTBUClient feign;

  @Scheduled(fixedRate = 10000)
  public void generateBattles() {

    for (int i = 0; i <= 29; i++) {
      
      int randomElement = battleMode.get(random.nextInt(battleMode.size()));

      BattleDeclaration declaration = new BattleDeclaration();

      declaration.setHomeEmperor("Home");
      Map<String, Integer> homeUnits = new HashMap<>();
      while (homeUnits.size() < randomElement) {
        homeUnits.put(getRandomUnit(getRandomNumber(37)), 15);
      }


      declaration.setAwayEmperor("Away");
      Map<String, Integer> awayUnits = new HashMap<>();
      while (awayUnits.size() < randomElement) {
        String unitToPut = getRandomUnit(getRandomNumber(37));
        if (!homeUnits.containsKey(unitToPut)) {
          awayUnits.put(unitToPut, 15);
        }
      }

      declaration.setHomeUnits(homeUnits);
      declaration.setAwayUnits(awayUnits);
      feign.postBattleDeclaration(declaration);
    }



  }

  public String getRandomUnit(Integer unitNumber) {

    final Map<Integer, String> unitList = new HashMap<>();

    unitList.put(1, "Knight");
    unitList.put(2, "Berserker");
    unitList.put(3, "Ranger");
    unitList.put(4, "Dragon");
    unitList.put(5, "Archer");
    unitList.put(6, "Viking");
    unitList.put(7, "Mage");
    unitList.put(8, "Warlock");
    unitList.put(9, "Priest");
    unitList.put(10, "Shaman");
    unitList.put(11, "Swordmaster");
    unitList.put(12, "Paladin");
    unitList.put(13, "Lancer");
    unitList.put(14, "Cavalier");
    unitList.put(15, "Infernal");
    unitList.put(16, "Amazon");
    unitList.put(17, "Monk");
    unitList.put(18, "Druid");
    unitList.put(19, "Barbarian");
    unitList.put(20, "Shadowdancer");
    unitList.put(21, "Archmage");
    unitList.put(22, "Duelist");
    unitList.put(23, "Siren");
    unitList.put(24, "Templar");
    unitList.put(25, "Pirate");
    unitList.put(26, "Gladiator");
    unitList.put(27, "Demon");
    unitList.put(28, "Beastmaster");
    unitList.put(29, "Sorcerer");
    unitList.put(30, "Hellhound");
    unitList.put(31, "Warlord");
    unitList.put(32, "Inquisitor");
    unitList.put(33, "Witcher");
    unitList.put(34, "Stormlord");
    unitList.put(35, "WhiteMage");
    unitList.put(36, "Valkyrie");

    return unitList.get(unitNumber);

  }

  public Integer getRandomNumber(Integer bound) {

    return random.ints(1, bound).findFirst().getAsInt();
  }

}
