package org.khana.khanaserver.service.model

data class ProductFilter(
    val brand: String = BrandFilterOption.ALL.displayName,
    val gender: String = GenderFilterOption.ALL.displayName,
    val sortedBy: String = SortByFilterOption.LATEST.displayName,
    val minPrice: Int = 0,
    val maxPrice: Int = 9999,
    val reviews: String = ReviewsFilterOption.ALL.displayName
)