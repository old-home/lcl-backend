package com.graywings.lcl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LclBackendApplication

fun main(args: Array<String>) {
    runApplication<LclBackendApplication>(*args)
}
