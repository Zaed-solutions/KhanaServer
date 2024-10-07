package org.khana.khanaserver.service.mapper

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone.Companion.UTC
import kotlinx.datetime.toInstant
import org.bson.types.ObjectId
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
fun List<CategoryEntity>.tolabels() = map { it.asLabel() }
fun List<ProductEntity>.toProductsDto() = map { it.toProductDto() }

fun CategoryDto.toCategoryEntity() = CategoryEntity(
    categoryImage = this.categoryImage,
    categoryTitle = this.categoryTitle,
)

fun CategoryEntity.toCategoryDto() = CategoryDto(
    categoryImage = this.categoryImage,
    categoryTitle = this.categoryTitle,
)
fun CategoryEntity.asLabel()= categoryTitle
fun UserDto.toUserEntity() = UserEntity(
    id = ObjectId().toString(),
    createdAt = LocalDateTime.now().toInstant(UTC).toEpochMilliseconds(),
    email = email,
    password = "",
    avatar = avatar,
    username = username,
    providerName = providerName,
    phoneNumber = phoneNumber,
)
fun UserEntity.toUserDto() = UserDto(
    id =id,
    username = username,
    email = email,
    avatar = avatar,
    phoneNumber = phoneNumber,
    providerName = providerName,
    createdAt = createdAt,
)
fun ProductDto.toProductEntity() = ProductEntity(
    id = id,
    name = name,
    rating = rating,
    thumbnailImageLink = thumbnailImageLink,
    previewImagesLinks = previewImagesLinks,
    category = category.toCategoryEntity(),
    description = description,
    availableSizes = availableSizes,
    availableColors = availableColors,
    basePrice = basePrice,
    isAvailable = isAvailable,
)
fun ProductEntity.toProductDto() = ProductDto(
    id = id,
    name = name,
    rating = rating,
    thumbnailImageLink = thumbnailImageLink,
    previewImagesLinks = previewImagesLinks,
    category = category.toCategoryDto(),
    description = description,
    availableSizes = availableSizes,
    availableColors = availableColors,
    basePrice = basePrice,
    isAvailable = isAvailable,
)
fun CartItemEntity.toCartItemDto() = CartItemDto(
    id = id,
    userId = userId,
    productId = productId,
    productName = productName,
    productThumbnail = productThumbnail,
    productColor = productColor,
    productSize = productSize,
    productBasePrice = productBasePrice,
    quantity = quantity,
)
fun List<CartItemEntity>.toCartItemsDto() = map { it.toCartItemDto() }