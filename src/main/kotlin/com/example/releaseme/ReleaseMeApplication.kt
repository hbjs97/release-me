package com.example.releaseme

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class ReleaseMeApplication

fun main(args: Array<String>) {
    runApplication<ReleaseMeApplication>(*args)
}
