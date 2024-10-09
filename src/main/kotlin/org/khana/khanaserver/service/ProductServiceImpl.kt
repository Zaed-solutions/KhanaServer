package org.khana.khanaserver.service

import org.khana.khanaserver.data.entity.FlashSaleEntity
import org.khana.khanaserver.data.entity.WishlistedProductsEntity
import org.khana.khanaserver.exception.UserException
import org.khana.khanaserver.repository.*
import org.khana.khanaserver.service.mapper.toProductDto
import org.khana.khanaserver.service.mapper.toProductEntity
import org.khana.khanaserver.service.mapper.toProductsDto
import org.khana.khanaserver.service.model.ProductDto
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val categoryRepository: CategoryRepository,
    val flashSaleRepository: FlashSaleRepository,
    val wishListRepository: WishListRepository,
    val userRepository: UserRepository,
) : ProductService {
    override fun getAll(): List<ProductDto> = productRepository.findAll().toProductsDto()
    override fun insertOne(productDto: ProductDto) {
        productRepository.save(productDto.toProductEntity())
    }

    override fun fetchLabels(): List<String> = listOf("All", "Most Recent", "Most Popular")
    override fun flashSaleEndTime(): Long = flashSaleRepository.findFirstByOrderByEndTimeDesc()?.endTime ?: 0L
    override fun insertFlashSaleEndTime(endTime: Long) {
        flashSaleRepository.save(
            FlashSaleEntity(
                endTime = endTime
            )
        )
    }

    override fun getAllByCategoryTitle(title: String) =
        productRepository.findAllByCategory_categoryTitle(title).toProductsDto()

    override fun getAllByLabel(label: String): List<ProductDto> {
        return when (label) {
            "All" -> productRepository.findAll().toProductsDto()
            else -> emptyList()
        }
    }

    override fun getWishlistedProductsIdsByUserId(userId: String) =
        wishListRepository.findByUserId(userId)?.products?.map { it.id } ?: emptyList()

    override fun addWishlistedProduct(userId: String, productId: String) {
        val user = userRepository.findById(userId).orElseThrow {
            UserException("User Not Found")
        }
        val product = productRepository.findById(productId).orElseThrow()
        val result = wishListRepository.findByUserId(userId)
        if (result == null) {
            wishListRepository.save(
                WishlistedProductsEntity(
                    user = user, products = listOf(product)
                )
            )
        } else {
            val wishlistedProductsDto = result.products
            wishListRepository.save(result.copy(products = wishlistedProductsDto + product))
        }

    }

    override fun removeWishlistedProduct(userId: String, productId: String) {
        val product = productRepository.findById(productId).orElseThrow()
        val result = wishListRepository.findByUserId(userId)
        val products = result?.products ?: emptyList()
        if (result != null) {
            wishListRepository.save(result.copy(products = products - product))
        }
    }

    override fun checkIfIsProductWishlisted(userId: String, productId: String): Boolean {
        val result = wishListRepository.findByUserId(userId)
        return productId in (result?.products?.map { it.id } ?: emptyList())
    }

    override fun getWishlistedProductsByUserId(userId: String) =
        wishListRepository.findByUserId(userId)?.products?.toProductsDto() ?: emptyList()

    override fun searchProductsByName(name: String): List<ProductDto> =
        productRepository.findAllByNameContainingIgnoringCase(name).toProductsDto()

    override fun findProductById(productId: String) = productRepository.findById(productId).orElseThrow().toProductDto()
}