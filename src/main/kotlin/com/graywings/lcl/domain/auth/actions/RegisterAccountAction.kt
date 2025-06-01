package com.graywings.lcl.domain.auth.actions

import com.graywings.lcl.domain.auth.domain.Account
import com.graywings.lcl.domain.auth.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class RegisterAccountAction(private val accountRepository: AccountRepository) {

    fun register(email: String?, password: String?): Account {
        // TODO:リクエストから渡されたパラメータを渡す
        val account = Account(
            email = "dummyEmail",
            password = "dummyPassword"
        )
        return accountRepository.save(account);
    }
}
