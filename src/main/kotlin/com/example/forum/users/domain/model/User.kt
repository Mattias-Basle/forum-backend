package com.example.forum.users.domain.model

import java.time.LocalDateTime
import java.util.UUID

data class User(
    val uuid: UUID,
    val name: String,
    val password: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)
