package com.example.forum.users.adapter.controller

import com.example.forum.users.domain.model.UserMother
import com.example.forum.users.domain.port.command.CreateUserCommand
import com.example.forum.users.domain.usecase.CreateUserUseCase
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.transaction.annotation.Transactional


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerCT {

    private val baseUrl = "/v1/user"

    @Autowired
    private lateinit var createUserUseCase: CreateUserUseCase

    @Autowired
    private lateinit var mockMvc: MockMvc

//    @Test
//    @Rollback
//    @Transactional
//    fun `createUser - should create user successfully`() {
//        val mockedUser = UserMother.validModel()
//        val request = """
//            {
//                "name":"${mockedUser.name}",
//                "password":"${mockedUser.password}"
//            }
//        """.trimIndent()
//
//        mockMvc.perform(
//            MockMvcRequestBuilders
//            .post(baseUrl)
//                .accept(MediaType.APPLICATION_JSON)
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(request)
//        )
//            .andExpect(MockMvcResultMatchers.status().isCreated)
//
//        verify(exactly = 1) { createUserUseCase.execute(
//            CreateUserCommand(mockedUser.name, mockedUser.password)
//        ) }
//    }
}