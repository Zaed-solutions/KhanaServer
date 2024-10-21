package org.zaed.khana.data.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "legal_info")
data class LegalInfoEntity(
    @Id
    val id: String = "",
    val privacyPolicy: String = "",
    val termsAndConditions: String = ""
)
