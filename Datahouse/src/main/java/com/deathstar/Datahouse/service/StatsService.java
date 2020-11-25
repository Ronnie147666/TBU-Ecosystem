package com.deathstar.Datahouse.service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import com.deathstar.Datahouse.domain.MultiUnitStats;
import com.deathstar.Datahouse.domain.mongo.aggregation.AggregationScripts;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.deathstar.Datahouse.domain.SingleUnitStats;
import com.deathstar.Datahouse.properties.NetworkProperties;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;

@Service
public final class StatsService {

  @Autowired
  NetworkProperties networkProperties;

    public List<SingleUnitStats> getSingleUnitStats() throws IOException {
        SparkSession spark = getSparkSession("single_battle_record");

        // Create a JavaSparkContext using the SparkSession's SparkContext object
        JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());

        // Read data from MongoDB
        JavaMongoRDD<Document> rdd = MongoSpark.load(jsc);

        List<Document> wins = rdd.withPipeline(
                AggregationScripts.GET_CLASS_WINS_SINGLE).collect();
        List<Document> participations = rdd.withPipeline(
                AggregationScripts.GET_CLASS_PARTICIPATIONS_SINGLE).collect();

        List<SingleUnitStats> singleUnitStats = new ArrayList<>();

        participations.forEach(p -> {
                    SingleUnitStats u = new SingleUnitStats();
                    u.setName(p.get("_id").toString());
                    u.setParticipation(Integer.parseInt(p.get("count").toString()));
                    singleUnitStats.add(u);
                }
        );

        wins.forEach(w -> {
                    singleUnitStats.stream().filter(u -> u.getName().equals(w.get("_id"))).forEach(
                            u -> {
                                u.setWins(Integer.parseInt(w.get("count").toString()));
                            }
                    );
                }
        );

        jsc.close();

        return singleUnitStats;
    }

    public List<MultiUnitStats> getMultiUnitStats() throws IOException {
        SparkSession spark = getSparkSession("multi_battle_record");

        // Create a JavaSparkContext using the SparkSession's SparkContext object
        JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());

        // Read data from MongoDB
        JavaMongoRDD<Document> rdd = MongoSpark.load(jsc);

        List<Document> winPoints = rdd.withPipeline(
                AggregationScripts.GET_CLASS_WIN_POINTS_MULTI).collect();
        List<Document> losePoints = rdd.withPipeline(
                AggregationScripts.GET_CLASS_LOSE_POINTS_MULTI).collect();
        List<Document> participations = rdd.withPipeline(
                AggregationScripts.GET_CLASS_PARTICIPATIONS_SINGLE).collect();

        List<MultiUnitStats> multiUnitStats = new ArrayList<>();

        participations.forEach(p -> {
            MultiUnitStats u = new MultiUnitStats();
                    u.setName(p.get("_id").toString());
                    u.setParticipation(Integer.parseInt(p.get("count").toString()));
                    multiUnitStats.add(u);
                }
        );

        winPoints.forEach(w -> {
            multiUnitStats.stream().filter(u -> u.getName().equals(w.get("_id"))).forEach(
                            u -> {
                                u.setWinPoints(Integer.parseInt(w.get("count").toString()) * 2);
                            }
                    );
                }
        );

        losePoints.forEach(w -> {
            multiUnitStats.stream().filter(u -> u.getName().equals(w.get("_id"))).forEach(
                            u -> {
                                u.setLosePoints(Integer.parseInt(w.get("count").toString()));
                            }
                    );
                }
        );

        jsc.close();

        return multiUnitStats;
    }

    private SparkSession getSparkSession(String collection) {
        return SparkSession.builder().master(networkProperties.getSparkMaster()).appName("TBUMongoSparkConnector")
            .config("spark.mongodb.input.uri", networkProperties.getMongoUri())
            .config("spark.mongodb.input.collection", collection)
            .config("spark.mongodb.output.uri", networkProperties.getMongoUri())
            .config("spark.mongodb.input.partitioner", "MongoSinglePartitioner")
            .getOrCreate();
    }

    @Scheduled(fixedRate = 60000)
    private void printSingleUnitStats() throws IOException {
        List<SingleUnitStats> singleUnitStats = getSingleUnitStats().stream().sorted(Comparator.comparing(SingleUnitStats::getPercentage).reversed()).collect(Collectors.toList());
        System.out.println("--------- Single ---------");
        for (SingleUnitStats s : singleUnitStats) {
            System.out.println(s.getName()+" : "+ s.getWins()+"/"+s.getParticipation()+" ("+s.getPercentage()+"%)");
        }
    }

    @Scheduled(fixedRate = 60000)
    private void printMultiUnitStats() throws IOException {
        List<MultiUnitStats> multiUnitStats = getMultiUnitStats().stream().sorted(Comparator.comparing(MultiUnitStats::getPointsPerGame).reversed()).collect(Collectors.toList());
        System.out.println("--------- Multi ---------");
        for (MultiUnitStats s : multiUnitStats) {
            System.out.println(s.getName()+" : "+ s.getScore()+" P / "+s.getParticipation()+" G / "+s.getPointsPerGame()+" PPG");
        }
    }

}