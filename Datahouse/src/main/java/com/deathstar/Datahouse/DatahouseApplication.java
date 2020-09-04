package com.deathstar.Datahouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;
import com.deathstar.Datahouse.properties.NetworkProperties;


@SpringBootApplication
@EnableReactiveMongoRepositories
@EnableWebFlux
@EnableAutoConfiguration
@EnableConfigurationProperties(NetworkProperties.class)
public class DatahouseApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DatahouseApplication.class, args);
        SpringApplication application = new SpringApplication(DatahouseApplication.class);
        application.setWebApplicationType(WebApplicationType.REACTIVE);
        application.run(args);
	}

}
