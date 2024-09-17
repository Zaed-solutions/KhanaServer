package org.khana.khanaserver.service

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone.Companion.UTC
import kotlinx.datetime.ZoneOffset
import kotlinx.datetime.toInstant
import lombok.AllArgsConstructor
import org.khana.khanaserver.data.entity.UserEntity
import org.khana.khanaserver.exception.UserException
import org.khana.khanaserver.repository.UserRepository
import org.khana.khanaserver.util.LocalDateTimeUtil.now
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
@AllArgsConstructor
class UserService(
    private val userRepository: UserRepository
){


    fun saveNewUser(user: UserEntity) {
        userRepository.save(user.copy(createdAt = LocalDateTime.now().toInstant(UTC).toEpochMilliseconds()))
    }

    val allUsers: List<UserEntity>
        get() = userRepository.findAll()

    fun getUserById(id: String): UserEntity {
        return userRepository.findById(id).orElseThrow {
            UserException(
                message = "User with id $id not found",
                code = HttpStatus.NOT_FOUND.value()
            )
        }
    }

    fun updateUser(id: String, user: UserEntity) {
        userRepository.findById(id).orElseThrow {
            UserException(
                message = "User with id $id not found",
                code = HttpStatus.NOT_FOUND.value()            )
        }
        userRepository.save(user)
    }

    fun deleteUser(id: String) {
        userRepository.findById(id).orElseThrow {
            UserException(
                message = "User with id $id not found",
                code = HttpStatus.NOT_FOUND.value()            )
        }
        userRepository.deleteById(id)
    }
}
