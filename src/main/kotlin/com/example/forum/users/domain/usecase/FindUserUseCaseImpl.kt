package com.example.forum.users.domain.usecase

import com.example.forum.users.domain.exceptions.UserNotFoundException
import com.example.forum.users.domain.port.FindUserPort
import com.example.forum.users.domain.port.command.FindUserCommand

class FindUserUseCaseImpl(
    private val findUserPort: FindUserPort
): FindUserUseCase {

    override fun execute(command: FindUserCommand) = findUserPort.findByName(command.name)
        ?: throw UserNotFoundException(null)
}