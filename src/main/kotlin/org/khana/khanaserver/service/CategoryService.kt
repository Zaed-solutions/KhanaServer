package org.khana.khanaserver.service

import org.khana.khanaserver.service.model.CategoryDto

interface CategoryService {
    fun getAll(): List<CategoryDto>
    fun insert(category: CategoryDto)

}
