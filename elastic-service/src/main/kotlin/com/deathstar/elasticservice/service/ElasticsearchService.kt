package com.deathstar.elasticservice.service

import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestHighLevelClient

class ElasticsearchService(
    private val client: RestHighLevelClient
) {

    private fun createIndex(index: String){
        client.index(IndexRequest(index).create(true), RequestOptions.DEFAULT)
    }


}