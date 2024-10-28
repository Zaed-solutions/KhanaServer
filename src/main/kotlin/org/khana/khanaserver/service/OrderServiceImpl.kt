package org.khana.khanaserver.service

import kotlinx.datetime.Clock
import org.khana.khanaserver.repository.CartRepository
import org.khana.khanaserver.repository.OrderRepository
import org.khana.khanaserver.service.mapper.toDto
import org.khana.khanaserver.service.mapper.toEntity
import org.khana.khanaserver.service.mapper.toOrderDtos
import org.khana.khanaserver.service.model.*
import org.springframework.stereotype.Service
import java.time.Duration
import kotlin.time.Duration.Companion.days

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val cartRepository: CartRepository,
) : OrderService {
    override fun getAll(): List<OrderDto> = orderRepository.findAll().toOrderDtos()

    override fun fetchByUserId(userId: String): List<OrderDto> = orderRepository.findAllByUserId(userId).toOrderDtos()
    override fun fetchById(orderId: String) = orderRepository.findById(orderId).orElseThrow().toDto()


    override fun insertOne(orderDto: OrderDto): String{
        val order = orderRepository.save(orderDto.toEntity())
        val orderId = order.id
        val trackingId = "TRK"+orderId?.substring((orderId.length.div(2)), orderId.length)
        orderRepository.save(order.copy(trackingId = trackingId))
        val cartItemsIds = orderDto.cartItems.map { it.id }
        cartRepository.deleteAllById(cartItemsIds)
        return orderId?:""
    }

    override fun deleteOne(orderId: String) = orderRepository.deleteById(orderId)
    override fun updateOrderStatus(orderId: String, status: String) {
        val order = orderRepository.findById(orderId).orElseThrow()
        when(status){
            OrderStatus.CONFIRMED.name -> { orderRepository.save(order.copy(orderStatus = status, confirmedEpochSeconds = Clock.System.now().epochSeconds)) }
            OrderStatus.SHIPPED.name -> { orderRepository.save(order.copy(orderStatus = status, shippedEpochSeconds = Clock.System.now().epochSeconds)) }
            OrderStatus.DELIVERED.name -> { orderRepository.save(order.copy(orderStatus = status, deliveredEpochSeconds = Clock.System.now().epochSeconds)) }
            OrderStatus.CANCELLED.name -> { orderRepository.save(order.copy(orderStatus = status)) }
        }
    }

    override fun confirmOrderPayment(orderId: String, paymentMethod: String) {
        val paymentStatus = when(PaymentMethods.valueOf(paymentMethod)){
            PaymentMethods.CASH_ON_DELIVERY -> PaymentStatus.PAYMENT_ON_DELIVERY.name
            else -> "Unknown"
        }
        val order = orderRepository.findById(orderId).orElseThrow()
        val estimatedDeliveryInDays = ShippingType.entries.first{it.title == order.shippingType}.estimatedDeliveryInDays
        val now = Clock.System.now()
        val expectedDeliveryEpochSeconds = now.plus(estimatedDeliveryInDays.days).epochSeconds
        orderRepository.save(
            order.copy(
                orderStatus = OrderStatus.CONFIRMED.name,
                confirmedEpochSeconds = now.epochSeconds,
                paymentStatus = paymentStatus,
                expectedDeliveryEpochSeconds = expectedDeliveryEpochSeconds
            )
        )
    }
}