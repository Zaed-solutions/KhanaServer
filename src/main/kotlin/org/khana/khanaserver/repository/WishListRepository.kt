package org.khana.khanaserver.repository

import org.khana.khanaserver.data.entity.AdvertisementEntity
import org.khana.khanaserver.data.entity.UserEntity
import org.khana.khanaserver.data.entity.WishlistedProductsEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface WishListRepository :MongoRepository<WishlistedProductsEntity, String>{
    fun findByUserId(userId : String) : WishlistedProductsEntity?
}
