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
    private val categoryRepository: CategoryRepository,
    private val flashSaleRepository: FlashSaleRepository,
    private val wishListRepository: WishListRepository,
    private val userRepository: UserRepository,
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
        wishListRepository.findByUserId(userId)?.products?.map { it.id?:"" } ?: emptyList()

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

