package com.example.lclbackend.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1")
class AccountController {

    data class LoginRequest(
        val email: String,
        val password: String
    )

    @PostMapping("/accounts")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<String> {
        // 認証処理はここで行う（仮の実装）
        return if (request.email == "test@example.com" && request.password == "password123") {
            ResponseEntity.ok("ログイン成功")
        } else {
            ResponseEntity.status(401).body("認証失敗")
        }
    }
}
