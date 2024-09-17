package org.khana.khanaserver.controller

import org.khana.khanaserver.data.response.GenericResponse
import org.khana.khanaserver.service.CategoryService
import org.khana.khanaserver.service.model.CategoryDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/categories")
class CategoryController(
    val categoryService: CategoryService
) {
    @GetMapping("/all")
    fun all() = GenericResponse(
        code = 200,
        message = "Success",
        data = categoryService.getAll()
    )

    @PostMapping("/insert")
    fun insert(@RequestBody category: CategoryDto): GenericResponse<Unit> {
        categoryService.insert(category)
        return GenericResponse(
            code = 200,
            message = "Success",
        )
    }
}