package org.khana.khanaserver.service

import org.khana.khanaserver.repository.AdvertisementRepository
import org.khana.khanaserver.service.mapper.toAdvertisementEntity
import org.khana.khanaserver.service.mapper.toAdvertisementsDto


import org.khana.khanaserver.service.model.AdvertisementDto
import org.springframework.stereotype.Service

@Service
class AdvertisementServiceImpl(
    val advertisementRepository: AdvertisementRepository
) : AdvertisementService {
    override fun getAll() = advertisementRepository.findAll().toAdvertisementsDto()
    override fun insertOne(advertisement: AdvertisementDto) {
        val advertisementEntity = advertisement.toAdvertisementEntity()
        advertisementRepository.save(advertisementEntity)
    }
}