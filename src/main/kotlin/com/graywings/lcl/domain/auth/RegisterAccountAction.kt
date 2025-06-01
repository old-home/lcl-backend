package com.graywings.lcl.domain.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

class RegisterAccountAction(
    @Autowired
    accountRepository: AccountRepository
) {
    fun handle(accountRequest: AccountRequest) {
    }
}
