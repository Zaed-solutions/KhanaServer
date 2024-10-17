package org.khana.khanaserver.repository

import org.khana.khanaserver.data.entity.ContactInfoEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface ContactInfoRepository: MongoRepository<ContactInfoEntity, String>