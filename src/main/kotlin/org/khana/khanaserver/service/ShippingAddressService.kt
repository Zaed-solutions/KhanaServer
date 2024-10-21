package org.khana.khanaserver.service

import org.khana.khanaserver.service.model.ShippingAddressDto

interface ShippingAddressService {
    fun getAll(): List<ShippingAddressDto>
    fun getAllByUserId(userId: String): List<ShippingAddressDto>
    fun insertOne(shippingAddressDto: ShippingAddressDto): String
    fun deleteOne(shippingAddressId: String)
}