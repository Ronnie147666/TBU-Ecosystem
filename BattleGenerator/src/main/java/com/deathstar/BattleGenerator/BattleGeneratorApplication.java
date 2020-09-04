package com.deathstar.BattleGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import com.deathstar.BattleGenerator.generator.BattleDeclarationGenerator;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableFeignClients
@EnableEurekaClient
public class BattleGeneratorApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BattleGeneratorApplication.class, args);
		
        ConfigurableApplicationContext ctx = SpringApplication.run(BattleGeneratorApplication.class, args);

        BattleDeclarationGenerator generator = ctx.getBean(BattleDeclarationGenerator.class);
        generator.generateBattles();
		
	}

}
