package com.example.forum.users.adapter.controller

import com.example.forum.users.adapter.controller.dto.CreateUserRequestDto
import com.example.forum.users.adapter.controller.dto.CreateUserResponseDto
import com.example.forum.users.adapter.controller.dto.FindUserByNameResponseDto
import com.example.forum.users.adapter.controller.dto.UpdateUserPasswordRequestDto
import com.example.forum.users.domain.port.command.CreateUserCommand
import com.example.forum.users.domain.port.command.FindUserCommand
import com.example.forum.users.domain.port.command.UpdateUserPasswordCommand
import com.example.forum.users.domain.usecase.CreateUserUseCase
import com.example.forum.users.domain.usecase.FindUserUseCase
import com.example.forum.users.domain.usecase.UpdateUserUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/user")
class UserController(
    private val createUserUseCase: CreateUserUseCase,
    private val findUserUseCase: FindUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase
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

    @PutMapping("/{name}")
    fun updateUserPassword(
        @RequestParam("name")
        name: String,
        @RequestBody
        request: UpdateUserPasswordRequestDto
    ): ResponseEntity<Unit> {
        updateUserUseCase.updatePassword(
            UpdateUserPasswordCommand(name, request.newPassword)
        )

        return ResponseEntity.noContent().build()
    }
}