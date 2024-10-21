package org.khana.khanaserver.data.entity

import org.khana.khanaserver.service.model.Color
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "CartItem")
data class CartItemEntity(
    @Id
    val id: String? = null,
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