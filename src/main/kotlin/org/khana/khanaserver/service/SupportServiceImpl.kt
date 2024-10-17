package org.khana.khanaserver.service

import org.khana.khanaserver.repository.ContactInfoRepository
import org.khana.khanaserver.repository.FAQRepository
import org.khana.khanaserver.service.mapper.toDto
import org.khana.khanaserver.service.mapper.toEntity
import org.khana.khanaserver.service.mapper.toFAQDtos
import org.khana.khanaserver.service.model.ContactInfoDto
import org.khana.khanaserver.service.model.FAQDto
import org.springframework.stereotype.Service

@Service
class SupportServiceImpl(
    private val faqRepository: FAQRepository,
    private val contactInfoRepository: ContactInfoRepository
) : SupportService {
    override fun fetchContactInfo() = contactInfoRepository.findAll().first().toDto()
    override fun insertContactInfo(contactInfo: ContactInfoDto) {
        contactInfoRepository.save(contactInfo.toEntity())
    }

    override fun fetchFAQs(): List<FAQDto> = faqRepository.findAll().toFAQDtos()

    override fun insertFAQ(faq: FAQDto) {
        faqRepository.save(faq.toEntity())
    }
}