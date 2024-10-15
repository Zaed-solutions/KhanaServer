package org.khana.khanaserver.service.mapper

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone.Companion.UTC
import kotlinx.datetime.toInstant
import org.khana.khanaserver.data.entity.*
import org.khana.khanaserver.service.model.*
import org.khana.khanaserver.util.LocalDateTimeUtil.now

fun List<AdvertisementEntity>.toAdvertisementsDto() = map { it.toAdvertisementDto() }

fun AdvertisementEntity.toAdvertisementDto() = AdvertisementDto(
    title = this.title,
    description = this.description,
    backgroundImageUrl = this.backgroundImageUrl,
)

fun AdvertisementDto.toAdvertisementEntity() = AdvertisementEntity(
    title = this.title,
    description = this.description,
    backgroundImageUrl = this.backgroundImageUrl,
)

fun List<CategoryEntity>.toCategoriesDto() = map { it.toCategoryDto() }
fun List<ProductEntity>.toProductsDto() = map { it.toProductDto() }

fun CategoryDto.toCategoryEntity() = CategoryEntity(
    categoryImage = this.categoryImage,
    categoryTitle = this.categoryTitle,
)

fun CategoryEntity.toCategoryDto() = CategoryDto(
    categoryImage = this.categoryImage,
    categoryTitle = this.categoryTitle,
)

fun UserDto.toUserEntity() = UserEntity(
    id = id,
    createdAt = LocalDateTime.now().toInstant(UTC).toEpochMilliseconds(),
    email = email,
    password = "",
    avatar = avatar,
    username = username,
    providerName = providerName,
    phoneNumber = phoneNumber,
)

fun UserEntity.toUserDto() = UserDto(
    id = id,
    username = username,
    email = email,
    avatar = avatar,
    phoneNumber = phoneNumber,
    providerName = providerName,
    createdAt = createdAt,
)

fun ProductDto.toProductEntity() = ProductEntity(
    name = name,
    rating = rating,
    reviewCount = reviewCount,
    thumbnailImageLink = thumbnailImageLink,
    previewImagesLinks = previewImagesLinks,
    category = category.toCategoryEntity(),
    description = description,
    availableSizes = availableSizes,
    availableColors = availableColors,
    basePrice = basePrice,
    isAvailable = isAvailable,
    purchaseCount = purchaseCount,
    brand = brand,
    gender = gender
)

fun ProductEntity.toProductDto() = ProductDto(
    id = id ?: "",
    name = name,
    rating = rating,
    reviewCount = reviewCount,
    thumbnailImageLink = thumbnailImageLink,
    previewImagesLinks = previewImagesLinks,
    category = category.toCategoryDto(),
    description = description,
    availableSizes = availableSizes,
    availableColors = availableColors,
    basePrice = basePrice,
    isAvailable = isAvailable,
    purchaseCount = purchaseCount,
    brand = brand,
    gender = gender
)

fun CartItemEntity.toCartItemDto() = CartItemDto(
    id = id ?: "",
    userId = userId,
    productId = productId,
    productName = productName,
    productThumbnail = productThumbnail,
    productColor = productColor,
    productSize = productSize,
    productBasePrice = productBasePrice,
    appliedDiscountPercentage = appliedDiscountPercentage,
    quantity = quantity,
)

fun CartItemDto.toCartItemEntity() = CartItemEntity(
    userId = userId,
    productId = productId,
    productName = productName,
    productThumbnail = productThumbnail,
    productColor = productColor,
    productSize = productSize,
    productBasePrice = productBasePrice,
    appliedDiscountPercentage = appliedDiscountPercentage,
    quantity = quantity,
)

fun List<CartItemEntity>.toCartItemsDto() = map { it.toCartItemDto() }
fun List<CartItemDto>.toCartItemsEntities() = map { it.toCartItemEntity() }
fun CouponDto.toEntity() = CouponEntity(
    title = title,
    description = description,
    code = code,
    discountPercentage = discountPercentage,
    maxAmount = maxAmount,
    minAmount = minAmount,
)

fun CouponEntity.toDto() = CouponDto(
    id = id ?: "",
    title = title,
    description = description,
    code = code,
    discountPercentage = discountPercentage,
    maxAmount = maxAmount,
    minAmount = minAmount,
)

fun List<CouponEntity>.toCouponDtos() = map { it.toDto() }
fun ShippingAddressDto.toEntity() = ShippingAddressEntity(
    userId = userId,
    title = title,
    country = country,
    city = city,
    addressLine = addressLine,
    phoneNumber = phoneNumber,
)

fun ShippingAddressEntity.toDto() = ShippingAddressDto(
    id = id ?: "",
    userId = userId,
    title = title,
    country = country,
    city = city,
    addressLine = addressLine,
    phoneNumber = phoneNumber,
)

fun List<ShippingAddressEntity>.toShippingAddressDtos() = map { it.toDto() }
fun OrderDto.toEntity() = OrderEntity(
    userId = userId,
    cartItems = cartItems.toCartItemsEntities(),
    shippingAddress = shippingAddress.toEntity(),
    shippingType = shippingType,
    paymentStatus = paymentStatus,
    orderStatus = orderStatus,
    totalPrice = totalPrice,
)

fun OrderEntity.toDto() = OrderDto(
    id = id ?: "",
    userId = userId,
    cartItems = cartItems.toCartItemsDto(),
    shippingAddress = shippingAddress.toDto(),
    shippingType = shippingType,
    paymentStatus = paymentStatus,
    orderStatus = orderStatus,
    totalPrice = totalPrice,
)

fun List<OrderEntity>.toOrderDtos() = map { it.toDto() }

fun ProductReviewDto.toEntity() = ProductReviewEntity(
    userId = userId,
    productId = productId,
    rating = rating,
    review = review,
)
fun ProductReviewEntity.toDto() = ProductReviewDto(
    id = id?:"",
    userId = userId,
    productId = productId,
    rating = rating,
    review = review,
)