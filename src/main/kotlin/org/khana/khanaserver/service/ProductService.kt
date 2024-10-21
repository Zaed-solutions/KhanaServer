package org.khana.khanaserver.service

import org.khana.khanaserver.service.model.ProductDto
import org.khana.khanaserver.service.model.ProductFilter
import org.khana.khanaserver.service.model.ProductReviewDto

interface ProductService {
    fun getAll(): List<ProductDto>
    fun insertOne(productDto: ProductDto)
    fun fetchSortedByOptions(): List<String>
    fun flashSaleEndTime(): Long
    fun insertFlashSaleEndTime(endTime:Long)
    fun getAllByCategoryTitle(title: String): List<ProductDto>
    fun getAllByFilter(filter: ProductFilter): List<ProductDto>
    fun getWishlistedProductsIdsByUserId(userId: String): List<String>
    fun addWishlistedProduct(userId: String, productId: String)
    fun removeWishlistedProduct(userId: String, productId: String)
    fun findProductById(productId: String): ProductDto
    fun checkIfIsProductWishlisted(userId: String, productId: String): Boolean
    fun getWishlistedProductsByUserId(userId: String): List<ProductDto>
    fun searchProductsByName(name: String): List<ProductDto>
    fun addProductReview(review: ProductReviewDto)
    fun updateProductRating(productId: String, rating: Int)
}
