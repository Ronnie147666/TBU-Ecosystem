package com.deathstar.Datahouse.service;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import com.deathstar.Datahouse.domain.mongo.aggregation.AggregationScripts;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deathstar.Datahouse.domain.UnitStats;
import com.deathstar.Datahouse.properties.NetworkProperties;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;
import avro.shaded.com.google.common.collect.Lists;

@Service
public final class SparkService {

  @Autowired
  NetworkProperties networkProperties;

  static Map<String, Double> percentageMap = new HashMap<>();
  
  public void startSparkCalculations() throws IOException {

    SparkSession spark = SparkSession.builder().master(networkProperties.getSparkMaster()).appName("TBUMongoSparkConnector")
        .config("spark.mongodb.input.uri", networkProperties.getMongoUri())
        .config("spark.mongodb.input.collection", "battle_record")
        .config("spark.mongodb.output.uri", networkProperties.getMongoUri())
        .getOrCreate();
    
    // Create a JavaSparkContext using the SparkSession's SparkContext object
    JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());

    // Read data from MongoDB 
    JavaMongoRDD<Document> rdd = MongoSpark.load(jsc);

    JavaMongoRDD<Document> mutualWinsRDD = rdd.withPipeline(
            AggregationScripts.GET_CLASS_WINS);

    jsc.close();

  }

  private void printStatistics(JavaMongoRDD<Document> rdd, int battleType) {
    long mutCount=rdd.withPipeline(
        Lists.newArrayList(
            Document.parse((" { $match: { battleType: \""+battleType+"\" } }"))
            )).count();
    
    
    // Class wins / mutual
    
    JavaMongoRDD<Document> mutualWinsRDD = rdd.withPipeline(
        AggregationScripts.GET_CLASS_WINS);

    // Class participation / mutual
    
    JavaMongoRDD<Document> mutualParticipationsRDD = rdd.withPipeline(
        Lists.newArrayList(
            Document.parse(("{ $project: { \"battleSquad\":1 } },")),
            Document.parse(("{ $unwind: \"$battleSquad\" },")),
            Document.parse(("{ $group: { _id: \"$battleSquad\", count:{$sum:1} }},")),
            Document.parse(("{ $sort : { count : -1 }}"))
            ));    
    
    
    
    // Analyze data from MongoDB
    List<Document> mutWins = mutualWinsRDD.collect();
    List<Document> mutParticipations = mutualParticipationsRDD.collect();
    List<UnitStats> mutStats = getUnitsStats(mutWins, mutParticipations);
    printTotalBattles(mutCount, "Group Of "+battleType);
    for (UnitStats s:mutStats) {
      printUnitStats(s);
    }
    try {
      createCSVFile(mutStats, battleType);
      buildPercentagesMap(mutStats);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void printUnitStats(UnitStats s) {
    System.out.println(s.getName()+" : "+ s.getWins()+"/"+s.getParticipations()+" ("+s.getPercentage()+"%)");
  }

  private void printTotalBattles(long count, String type) {
    System.out.println("--------------- "+type+" ---------------");
    System.out.println("--------- Total Battles: "+count+" ---------");
  }

  
  private BigDecimal getPercentage(Long unitWins, Long totalMatches) {
    return BigDecimal.valueOf(((double) unitWins / totalMatches) * 100).setScale(2, RoundingMode.HALF_UP);
  }
  
  private List<UnitStats> getUnitsStats(List<Document> wins, List<Document> participations){
    
    List<UnitStats> stats = new ArrayList<>();
    
    Map<String, Integer> participationMap = getUnitParticipation(participations);
    
    for (Document w : wins) {
      Document d = (Document) w.get("_id");
      UnitStats s = new UnitStats();
      
      String winString = w.get("count").toString();
      String parString = d.get("unitType").toString();
      
      s.setName(d.get("unitType").toString());
      s.setWins(Integer.parseInt(winString));
      s.setParticipations(participationMap.get(parString));
      s.setPercentage(getPercentage(Long.valueOf(winString), Long.valueOf(participationMap.get(parString))));
      
      stats.add(s);
    }
    stats.sort(Comparator.comparing(UnitStats::getPercentage).reversed());
    
    return stats;
  }
  
  private Map<String, Integer> getUnitParticipation(List<Document> list){
    Map<String, Integer> map = new HashMap<>();
    for (Document d : list) {
      Document doc = (Document) d.get("_id");
      String count = d.get("count").toString();
      map.put(doc.getString("unitType"), Integer.valueOf(count));
    }
    return map;
  }

  public void createCSVFile(List<UnitStats> list, int battleType) throws IOException {
    FileWriter out = new FileWriter("Tbu-Group Of "+battleType+".csv");
    String[] header = { "Class", "Winrate"};
    try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
            .withHeader(header))) {
      for (UnitStats e : list){
        printer.printRecord(e.getName(), e.getPercentage());
      }
    }
   }

   public void buildPercentagesMap(List<UnitStats> list){
    list.forEach( u -> percentageMap.put(u.getName(), u.getPercentage().doubleValue()));
   }

   public Map<String, Double> getPercentagesMap(){
    return percentageMap;
   }

}
