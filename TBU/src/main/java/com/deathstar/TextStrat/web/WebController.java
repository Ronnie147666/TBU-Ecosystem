package com.deathstar.TextStrat.web;


import com.deathstar.TextStrat.domain.UnitType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.deathstar.TextStrat.service.WarRoom;
import com.deathstar.domain.BattleDeclaration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("tbu")
public class WebController {
	
	@Autowired
	WarRoom room;
	
    @Value("${server.port}")
    private String portNumber;	
	
    private final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

	@PostMapping
	public void initiateBattle(@RequestBody BattleDeclaration battle) {
		
		room.declareWar(battle);
		
		System.out.println(battle.toString());
		
//		LOGGER.info("Now on: {}",portNumber);
		

	}

	@GetMapping
	public HashMap<String, Map<String, Double>> getUnitStats() {

	HashMap<String, Map<String, Double>> units = new HashMap<>();

		Arrays.stream(UnitType.values()).forEach( u -> {

			Map<String, Double> stats = new HashMap<>();
			stats.put("hp", (double) u.getHp());
			stats.put("pAtt", (double) u.getpAtt());
			stats.put("mAtt", (double) u.getmAtt());
			stats.put("pDef", (double) u.getpDef());
			stats.put("mDef", (double) u.getmDef());
			stats.put("heal", (double) u.getHeal());
			stats.put("group", (double) u.getGroup());
			stats.put("modifier", u.getModifier());

			units.put(u.name(),stats);
		} );

		return units;
	}

}
