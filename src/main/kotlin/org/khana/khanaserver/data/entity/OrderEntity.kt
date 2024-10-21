package org.khana.khanaserver.data.entity

import kotlinx.datetime.Clock
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
