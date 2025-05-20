package com.graywings.lcl.domain.auth.domain

import jakarta.persistence.*

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
