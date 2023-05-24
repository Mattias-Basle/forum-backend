package com.example.forum.users.adapter.controller

import com.example.forum.users.adapter.controller.dto.CreateUserRequestDto
import com.example.forum.users.adapter.controller.dto.CreateUserResponseDto
import com.example.forum.users.domain.port.command.CreateUserCommand
import com.example.forum.users.domain.usecase.CreateUserUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/user")
class UserController(
    private val createUserUseCase: CreateUserUseCase
) {
    @PostMapping(produces = ["application/json"])
    fun createUser(
        @RequestBody
        request: CreateUserRequestDto
    ): ResponseEntity<CreateUserResponseDto> {
        val userCreated = createUserUseCase.execute(
            CreateUserCommand(request.name, request.password)
        )

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(userCreated)
    }
}