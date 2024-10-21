package org.khana.khanaserver.service

import org.khana.khanaserver.repository.CategoryRepository
import org.khana.khanaserver.service.mapper.toCategoriesDto
import org.khana.khanaserver.service.mapper.toCategoryEntity
import org.khana.khanaserver.service.model.CategoryDto
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(
    val categoryRepository: CategoryRepository
) : CategoryService {
    override fun getAll() = categoryRepository.findAll().toCategoriesDto()
    override fun insert(category: CategoryDto) {
        val categoryEntity = category.toCategoryEntity()
        categoryRepository.save(categoryEntity)
    }
}