package com.graywings.lcl.domain.auth.repository

import com.graywings.lcl.config.TestDatabaseConfig
import com.graywings.lcl.domain.auth.domain.Account
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@DataJpaTest
@ActiveProfiles("test")
@Import(TestDatabaseConfig::class)
class AccountRepositoryTest {

    @Autowired
    private lateinit var accountRepository: AccountRepository

    @Test
    fun `should save and retrieve account`() {
        // Given
        val email = "test@example.com"
        val password = "password123"
        val account = Account(email = email, password = password)

        // When
        val savedAccount = accountRepository.save(account)
        val retrievedAccount = accountRepository.findById(savedAccount.id).orElse(null)

        // Then
        assertNotNull(retrievedAccount)
        assertEquals(email, retrievedAccount.email)
        assertEquals(password, retrievedAccount.password)
    }

    @Test
    fun `should find account by email`() {
        // Given
        val email = "find-by-email@example.com"
        val password = "password456"
        val account = Account(email = email, password = password)
        accountRepository.save(account)

        // When
        val foundAccount = accountRepository.findByEmail(email)

        // Then
        assertNotNull(foundAccount)
        assertEquals(email, foundAccount.email)
        assertEquals(password, foundAccount.password)
    }
}
