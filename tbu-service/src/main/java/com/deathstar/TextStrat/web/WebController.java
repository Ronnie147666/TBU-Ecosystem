package com.deathstar.TextStrat.web;


import com.deathstar.TextStrat.service.UnitService;
import com.deathstar.domain.BattleRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.deathstar.TextStrat.service.WarService;
import com.deathstar.domain.BattleDeclaration;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("tbu")
public class WebController {

    @Autowired
    WarService warService;
    @Autowired
    UnitService unitService;

    @Value("${server.port}")
    private String portNumber;

    private final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    @PostMapping
    public BattleRecord initiateBattle(@RequestBody BattleDeclaration battle) {
        return warService.createWar(battle);
    }

    @GetMapping
    public HashMap<String, Map<String, Double>> getUnitStats() {
        return unitService.getUnitStats();
    }

}
