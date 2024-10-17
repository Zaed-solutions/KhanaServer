package org.khana.khanaserver.repository

import org.khana.khanaserver.data.entity.FAQEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface FAQRepository: MongoRepository<FAQEntity, String>