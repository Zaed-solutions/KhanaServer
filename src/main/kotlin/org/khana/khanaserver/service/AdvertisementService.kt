package org.khana.khanaserver.service

import org.khana.khanaserver.service.model.AdvertisementDto

interface AdvertisementService {
    fun getAll(): List<AdvertisementDto>
    fun insertOne(advertisement: AdvertisementDto)
}
