package com.example.forum.users.domain.model

import java.util.UUID

data class User(
    val uuid: UUID,
    val name: String,
    val password: String
)
