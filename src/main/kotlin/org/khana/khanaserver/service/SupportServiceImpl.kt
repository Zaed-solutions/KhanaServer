package org.khana.khanaserver.service

import org.khana.khanaserver.repository.ContactInfoRepository
import org.khana.khanaserver.service.mapper.toDto
import org.khana.khanaserver.service.mapper.toEntity
import org.zaed.khana.data.model.ContactInfoDto

class SupportServiceImpl(
//    private val FAQRepository: FAQRepository,
    private val contactInfoRepository: ContactInfoRepository
) : SupportService {
    override fun fetchContactInfo() = contactInfoRepository.findAll().first().toDto()
    override fun insertContactInfo(contactInfo: ContactInfoDto) {
        contactInfoRepository.save(contactInfo.toEntity())
    }
}