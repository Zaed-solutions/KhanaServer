package org.khana.khanaserver.controller

import org.khana.khanaserver.data.response.GenericResponse
import org.khana.khanaserver.service.CartService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cart")
class CartController(
    val cartService: CartService,
) {
    @PostMapping("/addToCart")
    fun addItemToCart(
        @RequestParam productId: String,
        @RequestParam userId: String,
        @RequestParam productColorName: String,
        @RequestParam productColorHex: String,
        @RequestParam productSize: String
    ) = GenericResponse(
        code = 200,
        message = "Success",
        data = cartService.addItemToCart(
            productSize = productSize,
            userId = userId,
            productId = productId,
            productColor = org.khana.khanaserver.service.model.Color(productColorName, productColorHex)
        )
    )

    @GetMapping("/applyPromoCode")
    fun applyPromoCodeDiscountPercentage(@RequestParam promoCode: String, @RequestParam cartItemsIds: List<String>) = GenericResponse(
        code = 200,
        message = "Success",
        data = cartService.applyPromoCode(promoCode, cartItemsIds)
    )

    @PutMapping("/updateItemQuantity")
    fun updateItemQuantity(@RequestParam cartItemId: String, @RequestParam newQuantity: Int) = GenericResponse(
        code = 200,
        message = "Success",
        data = cartService.updateItemQuantity(cartItemId, newQuantity)
    )

    @DeleteMapping("/removeCartItem")
    fun removeCartItem(@RequestParam cartItemId: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = cartService.removeCartItem(cartItemId)
    )

    @GetMapping("/userCartItems")
    fun fetchUserCartItems(@RequestParam userId: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = cartService.fetchUserCartItems(userId)
    )

    @GetMapping("/deliveryFee")
    fun fetchDeliveryFee(@RequestParam userId: String) = GenericResponse(
        code = 200,
        message = "Delivery fee fetched successfully",
        data = cartService.fetchDeliveryFee(userId)
    )

    @GetMapping("/fetchOrderedCartItem")
    fun fetchOrderedCartItem(@RequestParam orderId: String, @RequestParam productId: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = cartService.fetchOrderedCartItem(orderId, productId)
    )

}