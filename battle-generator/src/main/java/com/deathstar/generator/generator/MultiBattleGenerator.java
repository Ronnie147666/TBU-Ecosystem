package com.deathstar.generator.generator;

import java.util.ArrayList;
import java.util.List;
import com.deathstar.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.deathstar.generator.client.FeignTBUClient;

@Service
public class MultiBattleGenerator {

    private final Logger LOGGER = LoggerFactory.getLogger(MultiBattleGenerator.class);

    @Autowired
    FeignTBUClient feign;

    @Scheduled(fixedRate = 10000)
    public void generateMultiBattle() {

        BattleType randomBattleType = BattleType.getRandomMultiBattleType();

        BattleDeclaration declaration = new BattleDeclaration();

      /*
      Create home Emperor
       */
        EmperorDTO homeEmperor = new EmperorDTO();

        List<String> homeUnits = new ArrayList<>();

        for (int i = 0; i < randomBattleType.getNumber(); i++){
            homeUnits.add(RandomUnitGenerator.getRandomUnit());
        }
        homeEmperor.setName("Lord");
        homeEmperor.setUnits(homeUnits);
        homeEmperor.setStatPriority(StatPriority.HEALTH);

        declaration.setHomeEmperor(homeEmperor);
      /*
      Create away Emperor
       */

        EmperorDTO awayEmperor = new EmperorDTO();

        List<String> awayUnits = new ArrayList<>();

        for (int i = 0; i < randomBattleType.getNumber(); i++){
            awayUnits.add(RandomUnitGenerator.getRandomUnit());
        }
        awayEmperor.setName("King");
        awayEmperor.setUnits(awayUnits);
        awayEmperor.setStatPriority(StatPriority.HEALTH);

        declaration.setAwayEmperor(awayEmperor);

        declaration.setBattleType(randomBattleType);

        LOGGER.info("Created a Multi Battle Declaration");

        feign.postBattleDeclaration(declaration);
    }

}
