package org.khana.khanaserver.service

import org.khana.khanaserver.data.entity.FlashSaleEntity
import org.khana.khanaserver.data.entity.WishlistedProductsEntity
import org.khana.khanaserver.exception.UserException
import org.khana.khanaserver.repository.*
import org.khana.khanaserver.service.mapper.toEntity
import org.khana.khanaserver.service.mapper.toProductDto
import org.khana.khanaserver.service.mapper.toProductEntity
import org.khana.khanaserver.service.mapper.toProductsDto
import org.khana.khanaserver.service.model.ProductDto
import org.khana.khanaserver.service.model.ProductFilter
import org.khana.khanaserver.service.model.ProductReviewDto
import org.khana.khanaserver.service.model.SortByFilterOption
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository,
    private val productReviewRepository: ProductReviewRepository,
    private val flashSaleRepository: FlashSaleRepository,
    private val wishListRepository: WishListRepository,
) : ProductService {
    override fun getAll(): List<ProductDto> = productRepository.findAll().toProductsDto()
    override fun insertOne(productDto: ProductDto) {
        productRepository.save(productDto.toProductEntity())
    }

    override fun fetchSortedByOptions(): List<String> = SortByFilterOption.entries.map { it.displayName }
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

    override fun getAllByFilter(filter: ProductFilter): List<ProductDto> = productRepository.findProductsByFilter(filter).toProductsDto()

    override fun getWishlistedProductsIdsByUserId(userId: String) =
        wishListRepository.findByUserId(userId)?.productsIds ?: emptyList()

    override fun addWishlistedProduct(userId: String, productId: String) {
        val result = wishListRepository.findByUserId(userId)
        if (result == null) {
            wishListRepository.save(
                WishlistedProductsEntity(
                    userId = userId, productsIds = listOf(productId)
                )
            )
        } else {
            val wishlistedProductsDto = result.productsIds
            wishListRepository.save(result.copy(productsIds = wishlistedProductsDto + productId))
        }

    }

    override fun removeWishlistedProduct(userId: String, productId: String) {
        val result = wishListRepository.findByUserId(userId)
        val productsIds = result?.productsIds ?: emptyList()
        if (result != null) {
            wishListRepository.save(result.copy(productsIds = productsIds - productId))
        }
    }

    override fun checkIfIsProductWishlisted(userId: String, productId: String): Boolean {
        val result = wishListRepository.findByUserId(userId)
        return productId in (result?.productsIds?: emptyList())
    }

    override fun getWishlistedProductsByUserId(userId: String): List<ProductDto>{
        val productsIds = wishListRepository.findByUserId(userId)?.productsIds?: emptyList()
        return productRepository.findAllById(productsIds).toProductsDto()
    }

    override fun searchProductsByName(name: String): List<ProductDto> =
        productRepository.findAllByNameContainingIgnoringCase(name).toProductsDto()

    override fun addProductReview(review: ProductReviewDto) {
        productReviewRepository.insert(review.toEntity())
        updateProductRating(review.productId, review.rating)
    }

    override fun updateProductRating(productId: String, rating: Int) {
        val product = productRepository.findById(productId).orElseThrow()
        val newReviewCount = product.reviewCount + 1
        val newRating = ((product.rating * product.reviewCount) + rating)/newReviewCount
        productRepository.save(product.copy(rating = newRating, reviewCount = newReviewCount))
    }

    override fun findProductById(productId: String) = productRepository.findById(productId).orElseThrow().toProductDto()
}

