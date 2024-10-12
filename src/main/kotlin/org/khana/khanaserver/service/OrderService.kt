package org.khana.khanaserver.service

import org.khana.khanaserver.service.model.OrderDto

interface OrderService {
    fun getAll(): List<OrderDto>
    fun fetchByUserId(userId: String): List<OrderDto>
    fun insertOne(orderDto: OrderDto): String
    fun deleteOne(orderId: String)
}