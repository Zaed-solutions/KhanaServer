package org.khana.khanaserver.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "products")
data class ProductEntity(
    @Id
    val id: String = "",
    val name: String = "",
    val rating: Float = 0f,
    val thumbnailImageLink: String = "",
    val previewImagesLinks: List<String> = emptyList(),
    val category: CategoryEntity = CategoryEntity(),
    val details: String = "",
    val availableSizes: List<String> = emptyList(),
    val availableHexColors: List<String> = emptyList(),
    val basePrice: Float = 0f,
    val isAvailable: Boolean = true,
)
