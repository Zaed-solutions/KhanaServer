package org.khana.khanaserver.service.model

data class ProductDto(
    val id: String = "",
    val name: String = "",
    val rating: Float = 0f,
    val reviewCount: Int = 0,
    val thumbnailImageLink: String = "",
    val previewImagesLinks: List<String> = emptyList(),
    val category: CategoryDto = CategoryDto(),
    val description: String = "",
    val availableSizes: List<String> = emptyList(),
    val availableColors: List<Color> = emptyList(),
    val basePrice: Float = 0f,
    val isAvailable: Boolean = true,
    val purchaseCount: Int = 0,
    val brand: String = BrandFilterOption.ALL.displayName,
    val gender: String = GenderFilterOption.MEN.displayName
)