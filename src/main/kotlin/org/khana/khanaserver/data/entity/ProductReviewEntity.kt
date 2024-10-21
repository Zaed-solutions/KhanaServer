package org.khana.khanaserver.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "reviews")
data class ProductReviewEntity(
    @Id val id: String? = null,
    val userId: String = "",
    val productId: String = "",
    val rating: Int = 0,
    val review: String = "",
)
