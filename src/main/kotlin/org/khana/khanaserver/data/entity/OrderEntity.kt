package org.khana.khanaserver.data.entity

import org.khana.khanaserver.service.model.OrderStatus
import org.khana.khanaserver.service.model.PaymentStatus
import org.khana.khanaserver.service.model.ShippingAddressDto
import org.khana.khanaserver.service.model.ShippingType
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "orders")
data class OrderEntity(
    @Id
    val id: String? = null,
    val userId: String = "",
    val cartItems: List<CartItemEntity> = emptyList(),
    val shippingAddress: ShippingAddressEntity = ShippingAddressEntity(),
    val shippingType: String = ShippingType.ECONOMY.title,
    val paymentStatus: String = PaymentStatus.NOT_SET.name,
    val orderStatus: String = OrderStatus.PENDING.name,
    val totalPrice: Float = 0f,
)
