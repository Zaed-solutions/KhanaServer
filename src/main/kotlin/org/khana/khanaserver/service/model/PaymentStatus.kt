package org.khana.khanaserver.service.model

enum class PaymentStatus {
    NOT_SET,
    PAYMENT_ON_DELIVERY,
    PAYMENT_FAILED,
    PAYMENT_SUCCESSFUL,
    PAYMENT_PENDING
}
enum class PaymentMethods {
    CASH_ON_DELIVERY,
    PAYPAL,
}