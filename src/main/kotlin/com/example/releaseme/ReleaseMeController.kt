package com.example.releaseme

import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.net.InetAddress
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1")
class ReleaseMeController(
    @Value("\${word}") private val word: String,
) {
    @ApiResponse(responseCode = "200")
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("hello")
    fun hello(): String = "[${LocalDateTime.now()}][${InetAddress.getLocalHost().hostAddress}] - $word - v1"
}
