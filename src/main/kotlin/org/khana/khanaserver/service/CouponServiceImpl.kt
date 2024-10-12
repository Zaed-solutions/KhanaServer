package org.khana.khanaserver.service

import org.khana.khanaserver.data.entity.CouponEntity
import org.khana.khanaserver.repository.CouponRepository
import org.khana.khanaserver.service.mapper.toCategoryEntity
import org.khana.khanaserver.service.mapper.toDtos
import org.khana.khanaserver.service.mapper.toEntity
import org.khana.khanaserver.service.model.CouponDto
import org.springframework.stereotype.Service

@Service
class CouponServiceImpl(
    private val couponRepository: CouponRepository
) : CouponService {
    override fun getAll(): List<CouponDto> = couponRepository.findAll().toDtos()
    override fun insert(couponDto: CouponDto): CouponEntity = couponRepository.save(couponDto.toEntity())
}