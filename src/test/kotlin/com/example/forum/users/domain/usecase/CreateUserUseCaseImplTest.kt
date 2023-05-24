package com.example.forum.users.domain.usecase

import com.example.forum.users.domain.exceptions.UserAlreadyExistsException
import com.example.forum.users.domain.model.UserMother
import com.example.forum.users.domain.port.CreateUserPort
import com.example.forum.users.domain.port.FindUserPort
import com.example.forum.users.domain.port.command.CreateUserCommand
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class CreateUserUseCaseImplTest {

    @MockK
    private lateinit var findUserPort: FindUserPort

    @MockK
    private lateinit var createUserPort: CreateUserPort

    @InjectMockKs
    private lateinit var usecase: CreateUserUseCaseImpl

    @Test
    fun `should throw if user already exists`() {
        val mockedUser = UserMother.validModel()

        every { findUserPort.findByName(mockedUser.name) } returns mockedUser

        assertThrows<UserAlreadyExistsException> {
            usecase.execute(
                CreateUserCommand(mockedUser.name, mockedUser.password)
            )
        }

        verify(exactly = 1) { findUserPort.findByName(any()) }
        verify(exactly = 0) { createUserPort.create(any()) }
    }

    @Test
    fun `should create user successfully`() {
        val mockedUser = UserMother.validModel()

        every { findUserPort.findByName(mockedUser.name) } returns null
        every { createUserPort.create(any()) } returns mockedUser

        assertDoesNotThrow {
            usecase.execute(
            CreateUserCommand(mockedUser.name, mockedUser.password)
            )
        }

        verify(exactly = 1) { findUserPort.findByName(any()) }
        verify(exactly = 1) { createUserPort.create(any()) }
    }
}