package com.graywings.lcl.controller

import com.graywings.lcl.domain.auth.actions.RegisterAccountAction
import jakarta.validation.Valid
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1")
class AccountController(private val registerAccountAction: RegisterAccountAction) {

    data class LoginRequest(

        // NOTE:
        // email や password を nullable にしているのは、バリデーションエラーを正しく検出するため。
        // もし非nullable（String）にすると、リクエストでフィールドが欠落していた場合、
        // Bean Validation による検証（@NotBlank など）に到達する前に Jackson のデシリアライズエラー（Json parse error）になる。
        // そのため、null を許容しつつ @NotBlank や でバリデーションする構成にしている。
        @field:NotBlank(message = "メールアドレスは必須です")
        @field:Email(message = "メールアドレスの形式が不正です")
        val email: String?,

        @field:NotBlank(message = "パスワードは必須です")
        @field:Size(min = 8, message = "パスワードは8文字以上で入力してください")
        val password: String?
    )

    data class RegisterAccountRequest(

        // NOTE:
        // email や password を nullable にしているのは、バリデーションエラーを正しく検出するため。
        // もし非nullable（String）にすると、リクエストでフィールドが欠落していた場合、
        // Bean Validation による検証（@NotBlank など）に到達する前に Jackson のデシリアライズエラー（Json parse error）になる。
        // そのため、null を許容しつつ @NotBlank や でバリデーションする構成にしている。
        @field:NotBlank(message = "メールアドレスは必須です")
        @field:Email(message = "メールアドレスの形式が不正です")
        val email: String?,

        @field:NotBlank(message = "パスワードは必須です")
        @field:Size(min = 8, message = "パスワードは8文字以上で入力してください")
        val password: String?
    )

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: LoginRequest): ResponseEntity<String> {
        return ResponseEntity.ok(("ログイン成功"));
    }

    @PostMapping("/accounts")
    fun registerAccount(@Valid @RequestBody request: RegisterAccountRequest): ResponseEntity<String> {
        registerAccountAction.register(request.email, request.password);
        return ResponseEntity.ok("ユーザー登録成功");
    }

    @GetMapping("/accounts")
    fun test(request: LoginRequest): ResponseEntity<String> {
        return ResponseEntity.ok("Hello")
    }
}
