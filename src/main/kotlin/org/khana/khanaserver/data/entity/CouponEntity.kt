package org.khana.khanaserver.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "coupons")
data class CouponEntity(
    @Id
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val code: String = "",
    val discountPercentage: Float = 0f,
    val maxAmount: Float = 0f,
    val minAmount: Float = 0f,
)
