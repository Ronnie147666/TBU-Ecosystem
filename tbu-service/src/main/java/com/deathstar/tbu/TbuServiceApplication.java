package com.deathstar.tbu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.deathstar.tbu.properties.BattleConfiguration;
import com.deathstar.tbu.properties.NetworkProperties;

@EnableConfigurationProperties({BattleConfiguration.class , NetworkProperties.class})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class TbuServiceApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TbuServiceApplication.class, args);

	}
	
}
