package org.khana.khanaserver.service

import org.khana.khanaserver.data.entity.CartItemEntity
import org.khana.khanaserver.repository.CartRepository
import org.khana.khanaserver.repository.ProductRepository
import org.khana.khanaserver.service.mapper.toCartItemsDto
import org.khana.khanaserver.service.model.CartItemDto
import org.springframework.stereotype.Service
import java.awt.Color

@Service
class CartServiceImpl(
    val cartRepository: CartRepository,
    val productRepository: ProductRepository
) : CartService {
    override fun fetchPromoCodeDiscountPercentage(promoCode: String): Float {
        //TODO
        return 0f
    }

    override fun updateItemQuantity(cartItemId: String, newQuantity: Int) {
        val cart = cartRepository.findById(cartItemId).orElseThrow()
        cartRepository.save(cart.copy(quantity = newQuantity))
    }

    override fun removeCartItem(cartItemId: String) {
        cartRepository.deleteById(cartItemId)
    }

    override fun fetchUserCartItems(userId: String) = cartRepository.findByUserId(userId).toCartItemsDto()

    override fun addItemToCart(
        productId: String,
        userId: String,
        productColor: org.khana.khanaserver.service.model.Color,
        productSize: String
    ) {
        val product = productRepository.findById(productId).orElseThrow()
        val cartItems =cartRepository.findByUserId(userId)
        if(productId in cartItems.map { it.productId }){
            cartItems.first { it.productId == productId }.let{
                cartRepository.save(it.copy(quantity = it.quantity.inc()))
            }
        }else {
            cartRepository.save(
                CartItemEntity(
                    productId = productId,
                    productThumbnail = product.thumbnailImageLink,
                    productName = product.name,
                    productBasePrice = product.basePrice,
                    userId = userId,
                    productColor = productColor,
                    productSize = productSize,
                    quantity = 1
                )
            )
        }
    }

    override fun fetchDeliveryFee(userId: String): Float {
        //TODO
        return 0f
    }
}