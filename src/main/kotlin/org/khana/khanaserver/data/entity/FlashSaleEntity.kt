package org.khana.khanaserver.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "flashSale")
data class FlashSaleEntity(
    @Id
    val id: String="",
    val endTime: Long
)


