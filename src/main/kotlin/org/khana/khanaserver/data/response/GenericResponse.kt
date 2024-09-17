package org.khana.khanaserver.data.response

import lombok.AllArgsConstructor
import lombok.Data

@AllArgsConstructor
@Data
data class GenericResponse<T> (
    val code: Int = 0,
    val message: String="",
    val data: T? =null,
)
