package com.graywings.lcl.domain.auth.actions

import com.graywings.lcl.domain.auth.repository.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class RegisterAccountAction {
    @Autowired
    private val accountRepository: AccountRepository

    @PostMapping("")
    fun handle() {
    }
}
