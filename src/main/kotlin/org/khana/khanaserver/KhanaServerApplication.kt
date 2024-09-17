package org.khana.khanaserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KhanaServerApplication

fun main(args: Array<String>) {
    runApplication<KhanaServerApplication>(*args)
}
