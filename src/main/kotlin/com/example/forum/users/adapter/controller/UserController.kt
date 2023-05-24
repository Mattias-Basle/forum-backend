package com.example.forum.users.adapter.controller

import com.example.forum.users.adapter.controller.dto.CreateUserRequestDto
import com.example.forum.users.adapter.controller.dto.CreateUserResponseDto
import com.example.forum.users.adapter.controller.dto.FindUserByNameResponseDto
import com.example.forum.users.domain.port.command.CreateUserCommand
import com.example.forum.users.domain.port.command.FindUserCommand
import com.example.forum.users.domain.usecase.CreateUserUseCase
import com.example.forum.users.domain.usecase.FindUserUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/user")
class UserController(
    private val createUserUseCase: CreateUserUseCase,
    private val findUserUseCase: FindUserUseCase
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

    @GetMapping("/{name}")
    fun findUserByName(
        @RequestParam("name")
        name: String
    ): ResponseEntity<FindUserByNameResponseDto> {
        val user = findUserUseCase.execute(
            FindUserCommand(name)
        )
        return ResponseEntity.ok(
            FindUserByNameResponseDto(user)
        )
    }
}