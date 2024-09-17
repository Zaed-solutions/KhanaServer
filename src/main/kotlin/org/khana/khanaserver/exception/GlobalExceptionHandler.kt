package org.khana.khanaserver.exception

import org.khana.khanaserver.data.response.GenericResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(value = [UserException::class])
    fun handleMyCustomException(ex: UserException): GenericResponse<Void> {
        return GenericResponse(
            code = ex.code,
            message = ex.message,
        )
    }
}
