package org.khana.khanaserver.service.mapper

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone.Companion.UTC
import kotlinx.datetime.toInstant
import org.bson.types.ObjectId
import org.khana.khanaserver.data.entity.AdvertisementEntity
import org.khana.khanaserver.data.entity.CategoryEntity
import org.khana.khanaserver.data.entity.UserEntity
import org.khana.khanaserver.service.model.AdvertisementDto
import org.khana.khanaserver.service.model.CategoryDto
import org.khana.khanaserver.service.model.UserDto
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

fun CategoryDto.toCategoryEntity() = CategoryEntity(
    categoryImage = this.categoryImage,
    categoryTitle = this.categoryTitle,
)

fun CategoryEntity.toCategoryDto() = CategoryDto(
    categoryImage = this.categoryImage,
    categoryTitle = this.categoryTitle,
)

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