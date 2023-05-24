package com.example.forum.users.adapter.controller.dto

import com.example.forum.users.domain.model.User
import java.util.UUID

data class FindUserByNameResponseDto(
    val uuid: UUID,
    val name: String,
    val password: String
) {
    constructor(model: User): this(
        uuid = model.uuid,
        name = model.name,
        password = model.password
    )
}
