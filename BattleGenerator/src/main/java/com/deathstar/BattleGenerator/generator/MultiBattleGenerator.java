package com.deathstar.BattleGenerator.generator;

import java.util.ArrayList;
import java.util.List;

import com.deathstar.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.deathstar.BattleGenerator.client.FeignTBUClient;

@Service
public class MultiBattleGenerator {

    private final Logger LOGGER = LoggerFactory.getLogger(SingleBattleGenerator.class);

    @Autowired
    FeignTBUClient feign;

//    @Scheduled(fixedRate = 60000)
    public void generateMultiBattle() {


        BattleDeclarationNew declaration = new BattleDeclarationNew();

      /*
      Create home Emperor
       */
        EmperorDTO homeEmperor = new EmperorDTO();

        List<String> homeUnits = new ArrayList<>();

        while (homeUnits.size() < 5) {
            String randomUnit = RandomUnitGenerator.getRandomUnit();
                homeUnits.add(randomUnit);
        }
        homeEmperor.setUnits(homeUnits);
        homeEmperor.setStatPriority(StatPriority.HEALTH);

        declaration.setHomeEmperor(homeEmperor);
      /*
      Create away Emperor
       */

        EmperorDTO awayEmperor = new EmperorDTO();

        List<String> awayUnits = new ArrayList<>();

        while (awayUnits.size() < 5) {
            String randomUnit = RandomUnitGenerator.getRandomUnit();
                awayUnits.add(randomUnit);
        }
        awayEmperor.setUnits(awayUnits);
        awayEmperor.setStatPriority(StatPriority.HEALTH);

        declaration.setAwayEmperor(awayEmperor);

        declaration.setBattleType(BattleType.MULTI_FIVE);

        LOGGER.info("Created a Multi Battle Declaration");

        feign.postBattleDeclaration(declaration);
    }

}
