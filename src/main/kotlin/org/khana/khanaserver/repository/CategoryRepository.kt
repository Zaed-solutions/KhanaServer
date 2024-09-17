package org.khana.khanaserver.repository

import org.khana.khanaserver.data.entity.CategoryEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : MongoRepository<CategoryEntity, String>