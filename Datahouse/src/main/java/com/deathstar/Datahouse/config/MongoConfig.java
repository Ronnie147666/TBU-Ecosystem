package com.deathstar.Datahouse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.deathstar.Datahouse.domain.mongo"})
public class MongoConfig {

}
