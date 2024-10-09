package org.khana.khanaserver.repository

import org.khana.khanaserver.data.entity.ProductEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : MongoRepository<ProductEntity, String>{
    fun findAllByCategory_categoryTitle(category: String): MutableList<ProductEntity>
    @Query("{ 'name': { \$regex: ?0, \$options: 'i' } }")
    fun findAllByNameContainingIgnoringCase(name: String): MutableList<ProductEntity>
}