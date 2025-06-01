package com.graywings.lcl.domain.auth.actions

import com.graywings.lcl.domain.auth.Account
import com.graywings.lcl.domain.auth.AccountRepository
import org.springframework.stereotype.Service

@Service
class RegisterAccountAction(private val accountRepository: AccountRepository) {

    fun handle(email: String?, password: String?): Account {
        // TODO:リクエストから渡されたパラメータを渡す
        val account = Account(
            email = "dummyEmail",
            password = "dummyPassword"
        )
        return accountRepository.save(account);
    }
}
