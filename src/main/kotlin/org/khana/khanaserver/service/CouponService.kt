package org.khana.khanaserver.service

import org.khana.khanaserver.data.entity.CouponEntity
import org.khana.khanaserver.service.model.CouponDto

interface CouponService {
    fun getAll(): List<CouponDto>
    fun insert(couponDto: CouponDto): CouponEntity
}