package org.khana.khanaserver.service.model

import kotlinx.datetime.Clock

data class OrderDto(
    val id: String = "",
    val userId: String = "",
    val cartItems: List<CartItemDto> = emptyList(),
    val shippingAddress: ShippingAddressDto = ShippingAddressDto(),
    val shippingType: String = ShippingType.ECONOMY.title,
    val paymentStatus: String = PaymentStatus.NOT_SET.name,
    val orderStatus: String = OrderStatus.AWAITING_CONFIRMATION.name,
    val totalPrice: Float = 0f,
    val expectedDeliveryEpochSeconds: Long = 0,
    val trackingId: String = "",
    val createdAtEpochSeconds: Long = Clock.System.now().epochSeconds,
    val cancelledEpochSeconds: Long = 0,
    val confirmedEpochSeconds: Long = 0,
    val shippedEpochSeconds: Long = 0,
    val deliveredEpochSeconds: Long = 0,
    )
