package com.example.forum.users.adapter.repository.jpa

import com.example.forum.users.adapter.repository.jpa.entity.UserEntityMother
import com.example.forum.users.adapter.repository.jpa.mapper.UserMapper
import com.example.forum.users.domain.model.UserMother
import com.ninjasquad.springmockk.MockkBean
import com.ninjasquad.springmockk.SpykBean
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class UserRepositoryAdapterIT {

    @MockkBean
    private lateinit var repository: UserRepository

    @MockkBean
    private lateinit var mapper: UserMapper

    @SpykBean
    private lateinit var userRepositoryAdapter: UserRepositoryAdapter

    @Test
    fun `create - should save successfully`() {
        val mockedUser = UserMother.validModel()

        every { mapper.toEntity(any()) } returns UserEntityMother.validEntity()
        every { repository.save(any()) } returns UserEntityMother.validEntity()
        every { mapper.toDomain(any()) } returns mockedUser

        assertNotNull(
            userRepositoryAdapter.create(mockedUser)
        )

        verify(exactly = 1) { repository.save(any()) }
        verify(exactly = 1) { mapper.toEntity(any()) }
        verify(exactly = 1) { mapper.toDomain(any()) }
    }

    @Test
    fun `findByName - should return null if not exists`() {
        every { repository.findByName(any()) } returns null

        assertNull(
            userRepositoryAdapter.findByName("name")
        )

        verify(exactly = 1) { repository.findByName(any()) }
        verify(exactly = 0) { mapper.toEntity(any()) }
        verify(exactly = 0) { mapper.toDomain(any()) }
    }

    @Test
    fun `findByName - should return succefully`() {
        val mockedUser = UserMother.validModel()

        every { repository.findByName(any()) } returns UserEntityMother.validEntity()
        every { mapper.toDomain(any()) } returns mockedUser

        assertNotNull(
            userRepositoryAdapter.findByName("name")
        )

        verify(exactly = 1) { repository.findByName(any()) }
        verify(exactly = 0) { mapper.toEntity(any()) }
        verify(exactly = 1) { mapper.toDomain(any()) }
    }

    @Test
    fun `updateUserPassword - should save successfully`() {
        val mockedUser = UserMother.validModel()

        every { mapper.toEntity(any()) } returns UserEntityMother.validEntity()
        every { repository.save(any()) } returns UserEntityMother.validEntity()
        every { mapper.toDomain(any()) } returns mockedUser

        assertNotNull(
            userRepositoryAdapter.updateUserPassword(mockedUser)
        )

        verify(exactly = 1) { repository.save(any()) }
        verify(exactly = 1) { mapper.toEntity(any()) }
        verify(exactly = 1) { mapper.toDomain(any()) }
    }
}