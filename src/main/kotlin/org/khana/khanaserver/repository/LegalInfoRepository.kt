package org.khana.khanaserver.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import org.zaed.khana.data.model.LegalInfoEntity

@Repository
interface LegalInfoRepository: MongoRepository<LegalInfoEntity, String>