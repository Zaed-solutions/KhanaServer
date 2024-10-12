package org.khana.khanaserver.service.model

data class ShippingAddressDto(
    val id: String = "",
    val userId: String = "",
    val title: String = "",
    val country: String = "",
    val city: String = "",
    val addressLine: String = "",
    val phoneNumber: String = "",
)
