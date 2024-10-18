package org.khana.khanaserver.service

import org.khana.khanaserver.service.model.ContactInfoDto
import org.khana.khanaserver.service.model.FAQDto
import org.khana.khanaserver.service.model.LegalInfoDto

interface SupportService {
    fun fetchContactInfo(): ContactInfoDto
    fun insertContactInfo(contactInfo: ContactInfoDto)
    fun fetchLegalInfo(): LegalInfoDto
    fun insertLegalInfo(legalInfo: LegalInfoDto)
    fun fetchFAQs(): List<FAQDto>
    fun insertFAQ(faq: FAQDto)
}