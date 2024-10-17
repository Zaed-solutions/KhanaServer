package org.khana.khanaserver.service.model

data class ContactInfoDto(
    val customerSupportLines: List<String> = emptyList(),
    val whatsappNumbers: List<String> = emptyList(),
    val websiteUrls: List<String> = emptyList(),
    val facebookPagesLinks: List<String> = emptyList(),
    val twitterProfiles: List<String> = emptyList(),
    val instagramPages: List<String> = emptyList(),
)
