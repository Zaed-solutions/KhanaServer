package org.khana.khanaserver.repository

import org.khana.khanaserver.data.entity.ProductEntity
import org.khana.khanaserver.service.model.ProductFilter

interface CustomProductRepository {
    fun findProductsByFilter(filter: ProductFilter): List<ProductEntity>
}