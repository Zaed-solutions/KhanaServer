package org.khana.khanaserver.repository

import org.khana.khanaserver.data.entity.CouponEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CouponRepository : MongoRepository<CouponEntity, String>{
    fun findByCode(code: String): CouponEntity
}