package com.deathstar.elasticservice.service

import com.deathstar.elasticservice.domain.repository.ElasticsearchRepository
import org.springframework.stereotype.Service

@Service
class ElasticsearchService(
    private val elasticsearchRepository: ElasticsearchRepository
) {

    fun create(index: String, entity: Any) {
        elasticsearchRepository.create(index, entity)
    }

    fun get(index: String, id: String){
        elasticsearchRepository.get(index, id)
    }

}