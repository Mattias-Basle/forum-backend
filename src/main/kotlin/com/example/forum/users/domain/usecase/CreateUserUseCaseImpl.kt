package com.example.forum.users.domain.usecase

import com.example.forum.users.adapter.controller.dto.CreateUserResponseDto
import com.example.forum.users.domain.exceptions.UserAlreadyExistsException
import com.example.forum.users.domain.model.User
import com.example.forum.users.domain.port.CreateUserPort
import com.example.forum.users.domain.port.FindUserPort
import com.example.forum.users.domain.port.command.CreateUserCommand
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CreateUserUseCaseImpl(
    private val createUserPort: CreateUserPort,
    private val findUserPort: FindUserPort
): CreateUserUseCase {

    override fun execute(command: CreateUserCommand): CreateUserResponseDto {
        val (name, password) = command

        if (findUserPort.findByName(name) != null) {
            throw UserAlreadyExistsException(null)
        }

        val newUser = User(
            uuid = UUID.randomUUID(),
            name = name,
            password = password
        )

        val createdUser = createUserPort.create(newUser)

        return CreateUserResponseDto(createdUser)
    }
}