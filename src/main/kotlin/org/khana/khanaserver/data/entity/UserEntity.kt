package org.khana.khanaserver.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Users")
data class UserEntity (
 @Id val id: String,
 val avatar: String = "",
 val username: String = "",
 val email: String = "",
 val providerName: String = "",
 val password: String = "",
 val phoneNumber: String = "",
 val createdAt: Long = 0L,
)


