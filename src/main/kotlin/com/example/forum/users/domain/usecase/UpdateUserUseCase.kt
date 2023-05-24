package com.example.forum.users.domain.usecase

import com.example.forum.users.domain.port.command.UpdateUserPasswordCommand

interface UpdateUserUseCase {

    fun updatePassword(command: UpdateUserPasswordCommand)
}