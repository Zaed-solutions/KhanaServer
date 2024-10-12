package org.khana.khanaserver.controller

import org.khana.khanaserver.data.response.GenericResponse
import org.khana.khanaserver.service.ShippingAddressService
import org.khana.khanaserver.service.model.ShippingAddressDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/addresses")
class ShippingAddressController(
    private val shippingAddressService: ShippingAddressService
) {
    @PostMapping("/insert")
    fun insertShippingAddress(@RequestBody shippingAddress: ShippingAddressDto) = GenericResponse(
        code = 200,
        message = "Success",
        data = shippingAddressService.insertOne(shippingAddress)
    )
    @GetMapping("/byUserId")
    fun getAllByUserId(@RequestParam userId: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = shippingAddressService.getAllByUserId(userId)
    )
}