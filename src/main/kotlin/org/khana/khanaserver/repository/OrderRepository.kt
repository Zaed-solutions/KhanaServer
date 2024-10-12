package org.khana.khanaserver.repository

import org.khana.khanaserver.data.entity.OrderEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: MongoRepository<OrderEntity, String>{
    fun findAllByUserId(userId: String): MutableList<OrderEntity>
}