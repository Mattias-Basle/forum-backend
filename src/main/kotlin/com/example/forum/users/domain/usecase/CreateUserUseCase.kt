package com.example.forum.users.domain.usecase

import com.example.forum.users.adapter.controller.dto.CreateUserResponseDto
import com.example.forum.users.domain.port.command.CreateUserCommand

interface CreateUserUseCase {

    fun execute(command: CreateUserCommand): CreateUserResponseDto
}