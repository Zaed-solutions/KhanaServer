package org.khana.khanaserver.controller

import org.khana.khanaserver.data.response.GenericResponse
import org.khana.khanaserver.service.CouponService
import org.khana.khanaserver.service.model.CouponDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/coupons")
class CouponController (
    private val couponService: CouponService
) {
    @GetMapping("/all")
    fun all() = GenericResponse(
        code = 200,
        message = "Success",
        data = couponService.getAll()
    )
    @PostMapping("/insert")
    fun insert(@RequestBody coupon: CouponDto): GenericResponse<Unit> {
        couponService.insert(coupon)
        return GenericResponse(
            code = 200,
            message = "Success",
        )
    }
}