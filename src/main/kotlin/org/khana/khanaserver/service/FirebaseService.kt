package org.khana.khanaserver.service

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserRecord
import org.springframework.stereotype.Service

@Service
class FirebaseService {

    fun resetPassword(email: String, newPassword: String): String {
        return try {
            val userRecord = FirebaseAuth.getInstance().getUserByEmail(email)

            val updateRequest = UserRecord.UpdateRequest(userRecord.uid)
                .setPassword(newPassword)

            FirebaseAuth.getInstance().updateUser(updateRequest)

            "Password reset successfully for user with email $email."
        } catch (e: Exception) {
            "Failed to reset password for $email. Error: ${e.message}"
        }
    }
}
