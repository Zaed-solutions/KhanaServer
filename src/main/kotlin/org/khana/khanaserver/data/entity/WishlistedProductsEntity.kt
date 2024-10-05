package org.khana.khanaserver.data.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Users")
data class WishlistedProductsEntity(
    @Id val id: String = "",
    val user : UserEntity ,
    val products : List<ProductEntity>,
)


