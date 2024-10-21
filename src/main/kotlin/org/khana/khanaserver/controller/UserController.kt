package org.khana.khanaserver.controller;

import org.khana.khanaserver.service.EmailService
import org.khana.khanaserver.service.ResetTokenService
import org.khana.khanaserver.data.entity.UserEntity
import org.khana.khanaserver.data.response.GenericResponse
import org.khana.khanaserver.service.FirebaseService
import org.khana.khanaserver.service.UserService
import org.khana.khanaserver.service.model.UserDto
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService,
    private val emailService: EmailService,
    private val resetTokenService: ResetTokenService,
    val firebaseService: FirebaseService // Assume this will handle Firebase password reset
) {

    @GetMapping("/all")
    fun getAllUsers() =
        GenericResponse(
            200,
            "Success",
            userService.allUsers
        )

    @PostMapping("/insert")
    fun insertUser(@RequestBody user: UserDto): GenericResponse<Unit> {
        println(user)
        userService.saveNewUser(user)
        val result = GenericResponse(code = 200, message = "Success", data = Unit)
        println(result)
        return result;
    }
    @PutMapping("/updateByEmail")
    fun updateUser(@RequestBody user: UserDto): GenericResponse<Unit> {
        println(user)
        userService.updateByEmail(user)
        val result = GenericResponse(code = 200, message = "Success", data = Unit)
        println(result)
        return result;
    }

    @PutMapping("/updateUserAvatar")
    fun updateUserAvatar(@RequestParam userId: String, avatarUrl: String) = GenericResponse(
        code = 200,
        message = "Success",
        data = userService.updateUserAvatar(userId, avatarUrl)
    )

    @GetMapping("/byId")
    fun getUserById(@RequestParam id: String): GenericResponse<UserEntity> {
        println("id: $id")
        val user = userService.getUserById(id)
        return GenericResponse(200, "Success", user)
    }

    @PutMapping("/byId")
    fun updateUserById(@RequestBody user: UserEntity): GenericResponse<Void> {
        userService.updateUser(user.id, user)
        return GenericResponse(200, "Success", null)
    }

    @DeleteMapping("/byId")
    fun deleteUserById(@RequestBody id: String): GenericResponse<Void> {
        userService.deleteUser(id)
        return GenericResponse(200, "Success", null)
    }

    @GetMapping("/sendOtp")
    fun requestPasswordReset(@RequestParam("email") email: String): GenericResponse<Boolean> {
        println()
        val resetCode = emailService.generateResetCode()

        resetTokenService.saveResetCode(email, resetCode)

        // Send email with the reset code
        emailService.sendResetCode(email, resetCode)

        return GenericResponse(200, "Success", true)
    }

    @PostMapping("/reset-password")
    fun resetPassword(
        @RequestParam email: String,
        @RequestParam newPassword: String
    ): Boolean {
            firebaseService.resetPassword(email, newPassword)
            return true
    }
    @GetMapping("/verifyOtp")
    fun verifyCode(
        @RequestParam email: String,
        @RequestParam otp: String,
    ): GenericResponse<Boolean> {
        return if (resetTokenService.validateResetCode(email, otp)) {
            GenericResponse(200, "Success", true)
        } else {
            GenericResponse(200, "Success", false)
        }
    }
}


