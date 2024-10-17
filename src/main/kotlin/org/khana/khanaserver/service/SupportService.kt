package org.khana.khanaserver.service

import org.khana.khanaserver.service.model.ContactInfoDto
import org.khana.khanaserver.service.model.FAQDto

interface SupportService {
    fun fetchContactInfo(): ContactInfoDto
    fun insertContactInfo(contactInfo: ContactInfoDto)
    fun fetchFAQs(): List<FAQDto>
    fun insertFAQ(faq: FAQDto)
}