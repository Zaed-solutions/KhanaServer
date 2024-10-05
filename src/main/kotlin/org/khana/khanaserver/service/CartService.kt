package org.khana.khanaserver.service

import org.khana.khanaserver.service.model.AdvertisementDto
import org.khana.khanaserver.service.model.CartItemDto
import org.springframework.web.bind.annotation.RequestParam
import java.awt.Color

interface CartService {
    fun fetchPromoCodeDiscountPercentage(promoCode: String): Float
    fun updateItemQuantity(cartItemId: String, newQuantity: Int)
    fun removeCartItem(cartItemId: String)
    fun fetchUserCartItems(userId: String):List<CartItemDto>
    fun addItemToCart(productId: String, userId: String, productColor: org.khana.khanaserver.service.model.Color, productSize: String)
    fun fetchDeliveryFee(userId: String):Float
}
