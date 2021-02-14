package com.deathstar.elasticservice.config

import org.apache.http.HttpHost
import org.elasticsearch.client.RestClient
import org.elasticsearch.client.RestHighLevelClient

import org.springframework.context.annotation.Bean

class ElasticsearchConfig  {

    @Bean
    fun elasticRestClient(): RestHighLevelClient {
        val restClientBuilder = RestClient.builder(
            HttpHost("178.128.205.221", 9200, "http")
        )
        return RestHighLevelClient(restClientBuilder)
    }

}