package org.khana.khanaserver.repository

import org.khana.khanaserver.data.entity.ProductReviewEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductReviewRepository: MongoRepository<ProductReviewEntity, String>