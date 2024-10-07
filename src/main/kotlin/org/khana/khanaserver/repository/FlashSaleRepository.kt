package org.khana.khanaserver.repository

import org.khana.khanaserver.data.entity.CategoryEntity
import org.khana.khanaserver.data.entity.FlashSaleEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface FlashSaleRepository : MongoRepository<FlashSaleEntity, String>{
    fun findFirstByOrderByEndTimeDesc(): FlashSaleEntity?
}
