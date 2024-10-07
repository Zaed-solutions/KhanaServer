package org.khana.khanaserver.controller;

import lombok.AllArgsConstructor
import org.khana.khanaserver.data.entity.UserEntity
import org.khana.khanaserver.data.response.GenericResponse
import org.khana.khanaserver.service.UserService
import org.khana.khanaserver.service.model.UserDto
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService,
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
        val result= GenericResponse(code = 200, message = "Success", data = Unit)
        println(result)
        return  result ;
    }

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
}


