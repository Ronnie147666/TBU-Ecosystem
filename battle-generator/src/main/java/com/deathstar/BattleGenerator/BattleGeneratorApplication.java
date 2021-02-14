package com.deathstar.BattleGenerator;

import com.deathstar.BattleGenerator.generator.MultiBattleGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import com.deathstar.BattleGenerator.generator.SingleBattleGenerator;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableFeignClients
@EnableEurekaClient
public class BattleGeneratorApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BattleGeneratorApplication.class, args);
		
        ConfigurableApplicationContext ctx = SpringApplication.run(BattleGeneratorApplication.class, args);

//        SingleBattleGenerator singleGenerator = ctx.getBean(SingleBattleGenerator.class);
//        singleGenerator.generateSingleBattle();

//        MultiBattleGenerator multiGenerator = ctx.getBean(MultiBattleGenerator.class);
//        multiGenerator.generateMultiBattle();

	}

}
