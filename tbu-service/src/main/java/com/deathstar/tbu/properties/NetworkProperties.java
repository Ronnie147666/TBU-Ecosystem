package com.deathstar.tbu.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("network")
public class NetworkProperties {

  private String kafkaAddress;

  public String getKafkaAddress() {
    return kafkaAddress;
  }

  public void setKafkaAddress(String kafkaAddress) {
    this.kafkaAddress = kafkaAddress;
  }

}
