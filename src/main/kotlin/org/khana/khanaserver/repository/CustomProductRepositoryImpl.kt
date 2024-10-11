package org.khana.khanaserver.repository

import org.khana.khanaserver.data.entity.ProductEntity
import org.khana.khanaserver.service.model.*
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

@Repository
class CustomProductRepositoryImpl (
    private val mongoTemplate: MongoTemplate
): CustomProductRepository {
    override fun findProductsByFilter(filter: ProductFilter): List<ProductEntity> {
        val query = Query()
        if (filter.brand != BrandFilterOption.ALL.displayName) {
            query.addCriteria(Criteria.where("brand").`is`(filter.brand))
        }
        if (filter.gender != GenderFilterOption.ALL.displayName) {
            query.addCriteria(Criteria.where("gender").`is`(filter.gender))
        }
        query.addCriteria(Criteria.where("basePrice").gte(filter.minPrice).lte(filter.maxPrice))
        if (filter.reviews != ReviewsFilterOption.ALL.displayName) {
            query.addCriteria(Criteria.where("rating").gte(ReviewsFilterOption.entries.first { it.displayName == filter.reviews }.minRating))
        }
        when (filter.sortedBy) {
            SortByFilterOption.LATEST.displayName -> query.with(Sort.by(Sort.Direction.DESC, "createdAtEpochSeconds"))
            SortByFilterOption.PRICE_LOW_TO_HIGH.displayName -> query.with(Sort.by(Sort.Direction.ASC, "basePrice"))
            SortByFilterOption.PRICE_HIGH_TO_LOW.displayName -> query.with(Sort.by(Sort.Direction.DESC, "basePrice"))
            SortByFilterOption.POPULAR.displayName -> query.with(Sort.by(Sort.Direction.DESC, "purchaseCount"))
        }
        return mongoTemplate.find(query, ProductEntity::class.java)
    }
}