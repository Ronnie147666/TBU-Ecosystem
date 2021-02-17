package com.deathstar.elasticservice.domain.repository

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.elasticsearch.action.get.GetRequest
import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestHighLevelClient
import org.elasticsearch.common.xcontent.XContentType
import org.elasticsearch.index.query.BoolQueryBuilder
import org.elasticsearch.index.query.QueryBuilder
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.index.query.QueryBuilders.boolQuery
import org.elasticsearch.search.builder.SearchSourceBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class ElasticsearchRepository(
    private val client: RestHighLevelClient
) {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(ElasticsearchRepository::class.java)
    }

    fun create(index: String, entity: Any) {
        client.index(
            IndexRequest(index).source(jacksonObjectMapper().writeValueAsString(entity), XContentType.JSON),
            RequestOptions.DEFAULT
        )
        logger.info("{} entity saved to Elastic.", entity)
    }

    fun get(index: String, id: String){
        client.get(GetRequest(index, id), RequestOptions.DEFAULT)
    }

    fun search(){
        val searchSourceBuilder: SearchSourceBuilder
        val queryBuilders: BoolQueryBuilder = boolQuery()
//        queryBuilders.filter(QueryBuilders.matchQuery())
//        searchSourceBuilder.query(QueryBuilders.boolQuery().)
    }


}