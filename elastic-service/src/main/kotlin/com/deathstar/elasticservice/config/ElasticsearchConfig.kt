package com.deathstar.elasticservice.config

import org.apache.http.HttpHost
import org.bouncycastle.crypto.tls.ConnectionEnd
import org.elasticsearch.client.RestClient
import org.elasticsearch.client.RestHighLevelClient

import org.springframework.context.annotation.Bean
import org.bouncycastle.crypto.tls.ConnectionEnd.client
import org.springframework.context.annotation.Configuration

@Configuration
class ElasticsearchConfig  {

    @Bean
    fun elasticRestClient(): RestHighLevelClient {
        val restClientBuilder = RestClient.builder(
            HttpHost("178.128.205.221", 9200, "http")
        )
        restClientBuilder.setRequestConfigCallback { requestConfigBuilder ->
            requestConfigBuilder.setConnectTimeout(10000) // time until a connection with the server is established.
                .setSocketTimeout(60000) // time of inactivity to wait for packets[data] to receive.
                .setConnectionRequestTimeout(0)
        } // time to fetch a connection from the connection pool 0 for infinite.

        return RestHighLevelClient(restClientBuilder)
    }

}