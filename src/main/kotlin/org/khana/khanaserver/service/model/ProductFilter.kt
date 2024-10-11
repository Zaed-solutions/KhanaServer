package org.khana.khanaserver.service.model

data class ProductFilter(
    val brand: BrandFilterOption = BrandFilterOption.ALL,
    val gender: GenderFilterOption = GenderFilterOption.ALL,
    val sortedBy: SortByFilterOption = SortByFilterOption.LATEST,
    val priceRange: Pair<Int, Int> = Pair(0, 9999),
    val reviews: ReviewsFilterOption = ReviewsFilterOption.ALL
)