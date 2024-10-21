package org.khana.khanaserver.service.model

data class CouponDto(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val code: String = "",
    val discountPercentage: Float = 0f,
    val maxAmount: Float = 0f,
    val minAmount: Float = 0f,
)
