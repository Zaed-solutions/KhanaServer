package org.khana.khanaserver.service

import org.khana.khanaserver.service.model.AdvertisementDto
import org.khana.khanaserver.service.model.Color
import org.khana.khanaserver.service.model.ProductDto

interface ProductService {
    fun getAll(): List<ProductDto>
    fun insertOne(productDto: ProductDto)
    fun fetchLabels(): List<String>
    fun flashSaleEndTime(): Long
    fun insertFlashSaleEndTime(endTime:Long)
    fun getAllByCategoryTitle(title: String): List<ProductDto>
    fun getWishlistedProductsIdsByUserId(userId: String): List<String>
    fun addWishlistedProduct(userId: String, productId: String)
    fun removeWishlistedProduct(userId: String, productId: String)
    fun findProductById(productId: String): ProductDto
    fun checkIfIsProductWishlisted(userId: String, productId: String): Boolean
    fun addItemToCart(userId: String, productId: String, productColor: Color, productSize: String)
    fun getWishlistedProductsByUserId(userId: String): List<ProductDto>

}
