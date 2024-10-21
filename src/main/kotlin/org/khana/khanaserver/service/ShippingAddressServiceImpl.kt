package org.khana.khanaserver.service

import org.khana.khanaserver.repository.ShippingAddressRepository
import org.khana.khanaserver.service.mapper.toEntity
import org.khana.khanaserver.service.mapper.toShippingAddressDtos
import org.khana.khanaserver.service.model.ShippingAddressDto
import org.springframework.stereotype.Service

@Service
class ShippingAddressServiceImpl(
    private val shippingAddressRepository: ShippingAddressRepository
) : ShippingAddressService {
    override fun getAll() = shippingAddressRepository.findAll().toShippingAddressDtos()

    override fun getAllByUserId(userId: String) =
        shippingAddressRepository.findAllByUserId(userId).toShippingAddressDtos()

    override fun insertOne(shippingAddressDto: ShippingAddressDto) =
        shippingAddressRepository.save((shippingAddressDto.toEntity())).id?:""

    override fun deleteOne(shippingAddressId: String) {
        shippingAddressRepository.deleteById(shippingAddressId)
    }
}