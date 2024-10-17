package org.khana.khanaserver.service

import jakarta.mail.internet.MimeMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import java.util.UUID
import kotlin.random.Random

@Service
class EmailService(private val mailSender: JavaMailSender) {

    fun generateResetCode(): String {
        return Random.nextInt(1000, 9999).toString()
    }

    fun sendResetCode(email: String, resetCode: String) {
        val htmlContent = """
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Khana Password Reset</title>
            <style>
                body { 
                    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
                    margin: 0; 
                    padding: 0; 
                    background-color: #f7f9fc; 
                    color: #333; 
                }
                .container { 
                    max-width: 650px; 
                    margin: 30px auto; 
                    background-color: #ffffff; 
                    border-radius: 10px; 
                    box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15); 
                    overflow: hidden; 
                    border: 2px solid #f0f0f0;
                }
                .header { 
                    background: linear-gradient(135deg, #FF5F6D, #FFC371); 
                    color: white; 
                    padding: 25px; 
                    text-align: center; 
                    font-size: 26px; 
                    font-weight: bold; 
                }
                .content { 
                    padding: 25px; 
                    line-height: 1.8; 
                }
                .content h2 { 
                    color: #333; 
                    font-size: 22px; 
                    margin-bottom: 15px; 
                }
                .content p { 
                    font-size: 16px; 
                    color: #555; 
                }
                .code { 
                    background-color: #ffe7e7; 
                    border-left: 6px solid #FF5F6D; 
                    padding: 20px; 
                    margin: 30px 0; 
                    font-size: 20px; 
                    font-weight: bold; 
                    color: #FF5F6D; 
                    border-radius: 6px; 
                    box-shadow: 0 3px 10px rgba(255, 95, 109, 0.2); 
                }
                .footer { 
                    background-color: #f4f4f4; 
                    padding: 20px; 
                    text-align: center; 
                    font-size: 14px; 
                    border-top: 1px solid #e0e0e0; 
                }
                .footer p { 
                    margin: 0; 
                    color: #777; 
                    font-style: italic;
                }
                /* Text highlights */
                .highlight { 
                    color: #FFC371; 
                    font-weight: bold; 
                }
            </style>
        </head>
        <body>
            <div class="container">
                <div class="header">
                    Password Reset
                </div>
                <div class="content">
                    <h2>Hello!</h2>
                    <p>We received a request to reset your password. Use the code below to reset your password:</p>
                    <div class="code">RESET CODE: $resetCode</div>
                    <p>If you did not request a password reset, you can safely ignore this email. Your account is secure.</p>
                    <p class="highlight">Thank you for using Khana!</p>
                </div>
                <div class="footer">
                    <p>&copy; ${java.time.LocalDate.now().year} Khana. All rights reserved.</p>
                </div>
            </div>
        </body>
        </html>
    """.trimIndent()

        val message: MimeMessage = mailSender.createMimeMessage()

        val helper = MimeMessageHelper(message, true)
        helper.setTo(email)
        helper.setSubject("Password Reset Code")
        helper.setText(htmlContent, true)

        mailSender.send(message)
    }
}
