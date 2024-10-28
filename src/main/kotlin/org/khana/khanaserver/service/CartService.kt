package org.khana.khanaserver.service

import org.khana.khanaserver.service.model.CartItemDto

interface CartService {
    fun applyPromoCode(promoCode: String, cartItemsIds: List<String>): Float
    fun updateItemQuantity(cartItemId: String, newQuantity: Int)
    fun removeCartItem(cartItemId: String)
    fun fetchUserCartItems(userId: String):List<CartItemDto>
    fun addItemToCart(productId: String, userId: String, productColor: org.khana.khanaserver.service.model.Color, productSize: String)
    fun fetchDeliveryFee(userId: String):Float
    fun fetchOrderedCartItem(orderId: String, productId: String): CartItemDto
}
