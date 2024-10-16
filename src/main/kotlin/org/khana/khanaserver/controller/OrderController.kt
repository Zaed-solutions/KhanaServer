package org.khana.khanaserver.controller

import org.khana.khanaserver.data.response.GenericResponse
import org.khana.khanaserver.service.OrderService
import org.khana.khanaserver.service.model.OrderDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orders")
class OrderController (
    private val orderService: OrderService
){
    @GetMapping("/byUserId")
    fun fetchOrdersByUserId(@RequestParam userId: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = orderService.fetchByUserId(userId)
    )
    @GetMapping("/byId")
    fun fetchOrderById(@RequestParam orderId: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = orderService.fetchById(orderId)
    )
    @PostMapping("/updateStatus")
    fun updateOrderStatus(@RequestParam orderId: String, @RequestParam status: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = orderService.updateOrderStatus(orderId, status)
    )
    @PostMapping("/insert")
    fun placeOrder(@RequestBody order: OrderDto) = GenericResponse(
        code = 200,
        message = "Success",
        data = orderService.insertOne(order)
    )
    @DeleteMapping("/delete")
    fun deleteOrder(@RequestParam orderId: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = orderService.deleteOne(orderId)
    )
}