package com.example.forum.users.domain.usecase

import com.example.forum.users.domain.exceptions.UserNotFoundException
import com.example.forum.users.domain.model.UserMother
import com.example.forum.users.domain.port.FindUserPort
import com.example.forum.users.domain.port.UpdateUserPort
import com.example.forum.users.domain.port.command.UpdateUserPasswordCommand
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
class UpdateUserUseCaseImplTest {

    @MockK
    private lateinit var findUserPort: FindUserPort

    @MockK
    private lateinit var updateUserPort: UpdateUserPort

    @InjectMockKs
    private lateinit var usecase: UpdateUserUseCaseImpl

    @Test
    fun `updatePassword - should update user successfully`() {
        val mockedUser = UserMother.validModel()

        every { findUserPort.findByName(mockedUser.name) } returns mockedUser
        every { updateUserPort.updateUserPassword(mockedUser) } returns mockedUser

        assertDoesNotThrow {
            usecase.updatePassword(
                UpdateUserPasswordCommand(mockedUser.name, mockedUser.password)
            )
        }

        verify(exactly = 1) { findUserPort.findByName(any()) }
        verify(exactly = 1) { updateUserPort.updateUserPassword(any()) }
    }

    @Test
    fun `updatePassword - should throw when user not found`() {
        val mockedUser = UserMother.validModel()

        every { findUserPort.findByName(mockedUser.name) } returns null

        assertThrows<UserNotFoundException> {
            usecase.updatePassword(
                UpdateUserPasswordCommand(mockedUser.name, mockedUser.password)
            )
        }

        verify(exactly = 1) { findUserPort.findByName(any()) }
        verify(exactly = 0) { updateUserPort.updateUserPassword(any()) }
    }
}