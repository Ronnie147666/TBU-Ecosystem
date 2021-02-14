package com.deathstar.Datahouse.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("network")
public class NetworkProperties {

  private String kafkaAddress;
  
  private String mongoUri;

  private String sparkMaster;
  
  public String getKafkaAddress() {
    return kafkaAddress;
  }

  public void setKafkaAddress(String kafkaAddress) {
    this.kafkaAddress = kafkaAddress;
  }

  public String getMongoUri() { return mongoUri; }

  public void setMongoUri(String mongoUri) { this.mongoUri = mongoUri; }

  public String getSparkMaster() {
    return sparkMaster;
  }

  public void setSparkMaster(String sparkMaster) {
    this.sparkMaster = sparkMaster;
  }
  
}
