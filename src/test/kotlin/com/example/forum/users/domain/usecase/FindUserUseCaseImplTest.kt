package com.example.forum.users.domain.usecase

import com.example.forum.users.domain.exceptions.UserNotFoundException
import com.example.forum.users.domain.model.UserMother
import com.example.forum.users.domain.port.FindUserPort
import com.example.forum.users.domain.port.command.FindUserCommand
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
class FindUserUseCaseImplTest {

    @MockK
    private lateinit var findUserPort: FindUserPort

    @InjectMockKs
    private lateinit var usecase: FindUserUseCaseImpl

    @Test
    fun `should return user successfully`() {
        val mockedUser = UserMother.validModel()

        every { findUserPort.findByName(mockedUser.name) } returns mockedUser

        assertDoesNotThrow {
            usecase.execute(
                FindUserCommand(mockedUser.name)
            )
        }

        verify(exactly = 1) { findUserPort.findByName(any()) }
    }

    @Test
    fun `should throw when user not found`() {
        val mockedUser = UserMother.validModel()

        every { findUserPort.findByName(mockedUser.name) } returns null

        assertThrows<UserNotFoundException> {
            usecase.execute(
                FindUserCommand(mockedUser.name)
            )
        }

        verify(exactly = 1) { findUserPort.findByName(any()) }
    }
}