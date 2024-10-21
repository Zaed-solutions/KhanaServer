package org.khana.khanaserver.service.model



data class ProductReviewDto(
    val id: String = "",
    val userId: String = "",
    val productId: String = "",
    val rating: Int = 0,
    val review: String = "",
)


