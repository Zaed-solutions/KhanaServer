package org.khana.khanaserver.service.model

import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime

enum class ShippingType(val title: String, val estimatedDeliveryInDays: Int) {
    ECONOMY("Economy", 5),
    REGULAR("Regular", 3),
    EXPRESS("Express", 1)
}

fun ShippingType.getEstimatedDeliveryDate(): String {
    val currentDate = Clock.System.now().toLocalDateTime(TimeZone.UTC).date
    val estimatedDate = currentDate.plus(estimatedDeliveryInDays, DateTimeUnit.DAY)
    return "Estimated Arrival ${estimatedDate.dayOfMonth} ${estimatedDate.month.name.replaceFirstChar { it.uppercase() }} ${estimatedDate.year}"
}