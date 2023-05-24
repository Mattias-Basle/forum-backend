package com.example.forum.users.domain.port.command

data class UpdateUserPasswordCommand(
    val name: String,
    val password: String
)
