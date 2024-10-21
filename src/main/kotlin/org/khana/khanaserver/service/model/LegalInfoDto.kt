package org.khana.khanaserver.service.model

import org.springframework.data.annotation.Id

data class LegalInfoDto(
    val privacyPolicy: String = "",
    val termsAndConditions: String = ""
)
