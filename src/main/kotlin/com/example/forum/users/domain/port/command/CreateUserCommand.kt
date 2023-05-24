package com.example.forum.users.domain.port.command

data class CreateUserCommand(
    val name: String,
    val password: String
)
