package com.deathstar.TextStrat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.deathstar.TextStrat.properties.BattleConfiguration;
import com.deathstar.TextStrat.properties.NetworkProperties;

@EnableConfigurationProperties({BattleConfiguration.class , NetworkProperties.class})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class TextStratApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TextStratApplication.class, args);

	}
	
}
