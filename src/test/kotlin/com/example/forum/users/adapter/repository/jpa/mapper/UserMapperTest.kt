package com.example.forum.users.adapter.repository.jpa.mapper

import com.example.forum.users.adapter.repository.jpa.entity.UserEntityMother
import com.example.forum.users.domain.model.UserMother
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserMapperTest {

    @Autowired
    private lateinit var mapper: UserMapper

    @Test
    fun `should map from entity to model successfully`() {
        val entity = UserEntityMother.validEntity()

        val model = mapper.toDomain(entity)

        assertAll("check fields are equals", {
            assertEquals(entity.uuid, model.uuid)
            assertEquals(entity.name, model.name)
            assertEquals(entity.password, model.password)
            assertEquals(entity.createdAt, model.createdAt)
            assertEquals(entity.updatedAt, model.updatedAt)
        })
    }

    @Test
    fun `should map from model to entity successfully`() {
        val model = UserMother.validModel()

        val entity = mapper.toEntity(model)

        assertAll("check fields are equals", {
            assertEquals(entity.uuid, model.uuid)
            assertEquals(entity.name, model.name)
            assertEquals(entity.password, model.password)
            assertEquals(entity.createdAt, model.createdAt)
            assertEquals(entity.updatedAt, model.updatedAt)
        })
    }
}