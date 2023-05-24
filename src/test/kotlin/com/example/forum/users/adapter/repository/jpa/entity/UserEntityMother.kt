package com.example.forum.users.adapter.repository.jpa.entity

import java.time.LocalDateTime
import java.util.UUID

object UserEntityMother {

    fun validEntity(uuid: UUID = UUID.randomUUID()) = UserEntity(
        id = 1,
        uuid = uuid,
        name = "username",
        password = "password",
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )
}