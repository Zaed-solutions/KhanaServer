package org.khana.khanaserver.service

import org.khana.khanaserver.repository.OrderRepository
import org.khana.khanaserver.service.mapper.toOrderDtos
import org.khana.khanaserver.service.mapper.toEntity
import org.khana.khanaserver.service.model.OrderDto
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository
) : OrderService {
    override fun getAll(): List<OrderDto> = orderRepository.findAll().toOrderDtos()

    override fun fetchByUserId(userId: String): List<OrderDto> = orderRepository.findAllByUserId(userId).toOrderDtos()


    override fun insertOne(orderDto: OrderDto) = orderRepository.save(orderDto.toEntity()).id

    override fun deleteOne(orderId: String) = orderRepository.deleteById(orderId)
}