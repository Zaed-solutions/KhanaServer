package org.khana.khanaserver.exception

import lombok.AllArgsConstructor
import lombok.Data

@AllArgsConstructor
@Data
data class UserException (
    override val message: String = "",
    val code: Int = 0,
): RuntimeException()


