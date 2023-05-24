package com.example.forum.users.domain.usecase

import com.example.forum.users.domain.model.User
import com.example.forum.users.domain.port.command.FindUserCommand

interface FindUserUseCase {

    fun execute(command: FindUserCommand): User
}