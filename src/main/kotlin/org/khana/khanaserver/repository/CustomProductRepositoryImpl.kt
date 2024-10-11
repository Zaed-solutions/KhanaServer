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
        if (filter.brand != BrandFilterOption.ALL) {
            query.addCriteria(Criteria.where("brand").`is`(filter.brand.displayName))
        }
        if (filter.gender != GenderFilterOption.ALL) {
            query.addCriteria(Criteria.where("gender").`is`(filter.gender.displayName))
        }
        query.addCriteria(Criteria.where("basePrice").gte(filter.priceRange.first).lte(filter.priceRange.second))
        if (filter.reviews != ReviewsFilterOption.ALL) {
            query.addCriteria(Criteria.where("rating").gte(filter.reviews.minRating))
        }
        when (filter.sortedBy) {
            SortByFilterOption.LATEST -> query.with(Sort.by(Sort.Direction.DESC, "createdAtEpochSeconds"))
            SortByFilterOption.PRICE_LOW_TO_HIGH -> query.with(Sort.by(Sort.Direction.ASC, "basePrice"))
            SortByFilterOption.PRICE_HIGH_TO_LOW -> query.with(Sort.by(Sort.Direction.DESC, "basePrice"))
            SortByFilterOption.POPULAR -> query.with(Sort.by(Sort.Direction.DESC, "purchaseCount"))
        }
        return mongoTemplate.find(query, ProductEntity::class.java)
    }
}