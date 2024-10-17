package org.khana.khanaserver.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener
import java.io.FileInputStream

@Configuration
class FirebaseConfig {

    @EventListener(ApplicationReadyEvent::class)
    fun initializeFirebase() {
        val serviceAccount = FileInputStream("src/main/resources/static/khana-d3a45-firebase-adminsdk-jqy36-4560ebf1a8.json")

        val options = FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build()

        FirebaseApp.initializeApp(options)
        println("Firebase has been initialized.")
    }
}
