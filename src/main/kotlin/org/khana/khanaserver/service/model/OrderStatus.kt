package org.khana.khanaserver.service.model

enum class OrderStatus {
    AWAITING_CONFIRMATION,
    CONFIRMED,
    SHIPPED,
    DELIVERED,
    CANCELLED
}