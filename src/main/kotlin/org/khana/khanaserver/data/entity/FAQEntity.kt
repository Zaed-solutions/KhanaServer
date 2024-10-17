package org.khana.khanaserver.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "faq")
data class FAQEntity(
    @Id
    val id: String? = null,
    val tag: String = "",
    val question: String = "",
    val answer: String = ""
)
