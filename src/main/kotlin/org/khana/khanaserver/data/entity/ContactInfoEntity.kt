package org.khana.khanaserver.data.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "contact_info")
data class ContactInfoEntity(
    val customerSupportLines: List<String> = emptyList(),
    val whatsappNumbers: List<String> = emptyList(),
    val websiteUrls: List<String> = emptyList(),
    val facebookPagesLinks: List<String> = emptyList(),
    val twitterProfiles: List<String> = emptyList(),
    val instagramPages: List<String> = emptyList(),
)
