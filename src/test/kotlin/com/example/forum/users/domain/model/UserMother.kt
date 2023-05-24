package com.example.forum.users.domain.model

import java.util.UUID

object UserMother {

    fun validModel(uuid: UUID = UUID.randomUUID()) = User(
        uuid = uuid,
        name = "username",
        password = "password"
    )
}