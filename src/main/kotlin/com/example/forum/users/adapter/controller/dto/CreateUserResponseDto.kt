package com.example.forum.users.adapter.controller.dto

import com.example.forum.users.domain.model.User
import java.time.LocalDateTime
import java.util.UUID

data class CreateUserResponseDto(
    val uuid: UUID,
    val name: String,
    val password: String,
    val createdAt: LocalDateTime
) {
    constructor(model: User) : this(
        uuid = model.uuid,
        name = model.name,
        password = model.password,
        createdAt = model.createdAt
    )
}