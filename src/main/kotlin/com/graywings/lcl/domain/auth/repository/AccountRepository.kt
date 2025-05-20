package com.graywings.lcl.domain.auth.repository

import com.graywings.lcl.domain.auth.domain.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<Account, Long> {
    fun findByEmail(email: String): Account?
}
