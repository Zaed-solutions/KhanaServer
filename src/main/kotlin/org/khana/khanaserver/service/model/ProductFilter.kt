package org.khana.khanaserver.service.model

data class ProductFilter(
    val brand: BrandFilterOption = BrandFilterOption.ALL,
    val gender: GenderFilterOption = GenderFilterOption.ALL,
    val sortedBy: SortByFilterOption = SortByFilterOption.LATEST,
    val minPrice: Int = 0,
    val maxPrice: Int = 9999,
    val reviews: ReviewsFilterOption = ReviewsFilterOption.ALL
)