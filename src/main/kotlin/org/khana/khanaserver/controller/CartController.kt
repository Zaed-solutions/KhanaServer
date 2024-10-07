package org.khana.khanaserver.controller

import org.khana.khanaserver.data.response.GenericResponse
import org.khana.khanaserver.service.AdvertisementService
import org.khana.khanaserver.service.CartService
import org.khana.khanaserver.service.model.AdvertisementDto
import org.springframework.web.bind.annotation.*
import java.awt.Color

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

    @GetMapping("/promoCodeDiscountPercentage")
    fun fetchPromoCodeDiscountPercentage(@RequestParam promoCode: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = cartService.fetchPromoCodeDiscountPercentage(promoCode)
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


}