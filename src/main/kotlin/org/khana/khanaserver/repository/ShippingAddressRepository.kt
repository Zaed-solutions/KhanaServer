package org.khana.khanaserver.repository

import org.khana.khanaserver.data.entity.ShippingAddressEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ShippingAddressRepository: MongoRepository<ShippingAddressEntity, String> {
    fun findAllByUserId(userId: String): MutableList<ShippingAddressEntity>
}