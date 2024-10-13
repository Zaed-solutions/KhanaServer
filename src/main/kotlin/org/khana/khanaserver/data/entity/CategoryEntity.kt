package org.khana.khanaserver.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Category")
data class CategoryEntity(
    @Id
    val id :String? = null,
    val categoryImage: String = "",
    val categoryTitle: String = "",
)