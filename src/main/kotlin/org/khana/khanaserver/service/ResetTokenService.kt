package org.khana.khanaserver.service

import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class ResetTokenService {

    // In-memory map for storing email -> reset code
    private val resetTokenStore = ConcurrentHashMap<String, String>()

    fun saveResetCode(email: String, resetCode: String) {
        resetTokenStore[email] = resetCode
    }

    fun validateResetCode(email: String, resetCode: String): Boolean {
        return resetTokenStore[email] == resetCode
    }
}
