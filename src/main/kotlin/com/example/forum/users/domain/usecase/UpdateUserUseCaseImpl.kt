package com.example.forum.users.domain.usecase

import com.example.forum.users.domain.exceptions.UserNotFoundException
import com.example.forum.users.domain.port.FindUserPort
import com.example.forum.users.domain.port.UpdateUserPort
import com.example.forum.users.domain.port.command.UpdateUserPasswordCommand
import org.springframework.stereotype.Service

@Service
class UpdateUserUseCaseImpl(
    private val findUserPort: FindUserPort,
    private val updateUserPort: UpdateUserPort
): UpdateUserUseCase {

    override fun updatePassword(command: UpdateUserPasswordCommand) {
        val user = findUserPort.findByName(command.name)
            ?: throw UserNotFoundException(null)

        val updatedUser = user.copy(
            password = command.password
        )

        updateUserPort.updateUserPassword(updatedUser)
    }
}