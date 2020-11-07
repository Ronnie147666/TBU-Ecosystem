package com.deathstar.Datahouse.service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import com.deathstar.Datahouse.domain.mongo.aggregation.AggregationScripts;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.deathstar.Datahouse.domain.UnitStats;
import com.deathstar.Datahouse.properties.NetworkProperties;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;

@Service
public final class StatsService {

  @Autowired
  NetworkProperties networkProperties;

    public List<UnitStats> getUnitStats() throws IOException {
        SparkSession spark = getSparkSession();

        // Create a JavaSparkContext using the SparkSession's SparkContext object
        JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());

        // Read data from MongoDB
        JavaMongoRDD<Document> rdd = MongoSpark.load(jsc);

        List<Document> wins = rdd.withPipeline(
                AggregationScripts.GET_CLASS_WINS).collect();
        List<Document> participations = rdd.withPipeline(
                AggregationScripts.GET_CLASS_PARTICIPATIONS).collect();

        List<UnitStats> unitStats = new ArrayList<>();

        participations.forEach(p -> {
                    UnitStats u = new UnitStats();
                    u.setName(p.get("_id").toString());
                    u.setParticipation(Integer.parseInt(p.get("count").toString()));
                    unitStats.add(u);
                }
        );

        wins.forEach(w -> {
                    unitStats.stream().filter(u -> u.getName().equals(w.get("_id"))).forEach(
                            u -> {
                                u.setWins(Integer.parseInt(w.get("count").toString()));
                            }
                    );
                }
        );

        jsc.close();

        return unitStats;
    }

    private SparkSession getSparkSession() {
        return SparkSession.builder().master(networkProperties.getSparkMaster()).appName("TBUMongoSparkConnector")
            .config("spark.mongodb.input.uri", networkProperties.getMongoUri())
            .config("spark.mongodb.input.collection", "battle_record")
            .config("spark.mongodb.output.uri", networkProperties.getMongoUri())
            .config("spark.mongodb.input.partitioner", "MongoSinglePartitioner")
            .getOrCreate();
    }

    @Scheduled(fixedRate = 60000)
    private void printUnitStats() throws IOException {
        List<UnitStats> unitStats = getUnitStats().stream().sorted(Comparator.comparing(UnitStats::getPercentage).reversed()).collect(Collectors.toList());
        System.out.println("--------- Single Five ---------");
        for (UnitStats s : unitStats) {
            System.out.println(s.getName()+" : "+ s.getWins()+"/"+s.getParticipation()+" ("+s.getPercentage()+"%)");
        }
    }

}
