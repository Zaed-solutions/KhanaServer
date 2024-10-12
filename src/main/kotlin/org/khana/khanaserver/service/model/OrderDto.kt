package org.khana.khanaserver.service.model

data class OrderDto(
    val id: String = "",
    val userId: String = "",
    val cartItemsIds: List<String> = emptyList(),
    val shippingAddress: ShippingAddressDto = ShippingAddressDto(),
    val shippingType: String = ShippingType.ECONOMY.title,
    val paymentStatus: String = PaymentStatus.NOT_SET.name,
    val orderStatus: String = OrderStatus.PENDING.name,
    val totalPrice: Float = 0f,
    )
