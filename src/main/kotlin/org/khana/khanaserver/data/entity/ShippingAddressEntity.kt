package org.khana.khanaserver.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "shipping_addresses")
data class ShippingAddressEntity(
    @Id
    val id: String = "",
    val userId: String = "",
    val title: String = "",
    val country: String = "",
    val city: String = "",
    val addressLine: String = "",
    val phoneNumber: String = "",
)
