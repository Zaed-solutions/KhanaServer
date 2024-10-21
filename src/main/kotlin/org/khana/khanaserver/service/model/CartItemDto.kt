package org.khana.khanaserver.service.model

import org.khana.khanaserver.service.model.Color
import org.springframework.data.mongodb.core.mapping.Document

data class CartItemDto(
    val id: String = "",
    val userId: String = "",
    val productId: String = "",
    val productThumbnail: String = "",
    val productName: String = "",
    val productColor: Color = Color(),
    val productSize: String = "",
    val productBasePrice: Float = 0f,
    val appliedDiscountPercentage: Float = 0f,
    val quantity: Int = 0,
)