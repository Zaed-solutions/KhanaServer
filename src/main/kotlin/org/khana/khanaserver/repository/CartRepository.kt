package org.khana.khanaserver.repository

import org.khana.khanaserver.data.entity.AdvertisementEntity
import org.khana.khanaserver.data.entity.CartItemEntity
import org.khana.khanaserver.data.entity.UserEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CartRepository :MongoRepository<CartItemEntity, String>{
    fun findByUserId(userId : String) : List<CartItemEntity>
}
