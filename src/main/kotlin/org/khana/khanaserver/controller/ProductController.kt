package org.khana.khanaserver.controller

import org.khana.khanaserver.data.response.GenericResponse
import org.khana.khanaserver.service.CategoryService
import org.khana.khanaserver.service.ProductService
import org.khana.khanaserver.service.model.CategoryDto
import org.khana.khanaserver.service.model.ProductDto
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.awt.Color

@RestController
@RequestMapping("/products")
class ProductController(
    val productService: ProductService,
) {
    @GetMapping("/all")
    fun all() = GenericResponse(
        code = 200,
        message = "Success",
        data = productService.getAll()
    )

    @GetMapping("/labels")
    fun fetchLabels() = GenericResponse(
        code = 200,
        message = "Success",
        data = productService.fetchLabels()
    )

    @PostMapping("/insert")
    fun insert(@RequestBody product: ProductDto): GenericResponse<Unit> {
        productService.insertOne(product)
        return GenericResponse(
            code = 200,
            message = "Success",
        )
    }

    @GetMapping("/FlashSaleEndTime")
    fun fetchFlashSaleEndTime() = GenericResponse(
        code = 200,
        message = "Success",
        data = productService.flashSaleEndTime()
    )

    @PostMapping("/insrtFlashSaleEndTime")
    fun insertFlashSaleEndTime(@RequestParam endTime: Long) = GenericResponse(
        code = 200,
        message = "Success",
        data = productService.insertFlashSaleEndTime(endTime),
    )

    @GetMapping("/byCategory")
    fun fetchProductsByCategory(@RequestParam categoryTitle: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = productService.getAllByCategoryTitle(categoryTitle)
    )
    @GetMapping("/byLabel")
    fun fetchProductsByLabel(@RequestParam label: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = productService.getAllByLabel(label)
    )

    @GetMapping("/byId")
    fun getProductById(@RequestParam productId: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = productService.findProductById(productId)
    )

    @GetMapping("/wishListProductsIdByUserId")
    fun fetchWishlistedProductsIds(@RequestParam userId: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = productService.getWishlistedProductsIdsByUserId(userId)
    )

    @GetMapping("/wishListProductsByUserId")
    fun fetchWishlistedProducts(@RequestParam userId: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = productService.getWishlistedProductsByUserId(userId)
    )


    @PostMapping("/WishlistedProduct")
    fun addWishlistedProduct(@RequestParam userId: String, @RequestParam productId: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = productService.addWishlistedProduct(userId, productId)
    )

    @GetMapping("/checkIfIsProductWishlisted")
    fun checkIfIsProductWishlisted(@RequestParam userId: String, @RequestParam productId: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = productService.checkIfIsProductWishlisted(userId, productId)
    )

    @DeleteMapping("/WishlistedProduct")
    fun removeWishlistedProduct(@RequestParam userId: String, @RequestParam productId: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = productService.removeWishlistedProduct(userId, productId)
    )


}