package org.khana.khanaserver.service

import org.zaed.khana.data.model.ContactInfoDto

interface SupportService {
    fun fetchContactInfo(): ContactInfoDto
    fun insertContactInfo(contactInfo: ContactInfoDto)
}