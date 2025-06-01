package com.graywings.lcl.domain.auth

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "accounts")
class Account(
    @Column(nullable = false, length = 256)
    val email: String,

    @Column(nullable = false, length = 64)
    val password: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
)
