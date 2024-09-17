package org.khana.khanaserver.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Advertisements")
data class AdvertisementEntity(
    @Id
    val id: String="",
    val title: String="",
    val description: String="",
    val backgroundImageUrl: String="",
)


