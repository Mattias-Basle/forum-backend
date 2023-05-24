package com.example.forum.users.adapter.repository.jpa

import com.example.forum.users.adapter.repository.jpa.mapper.UserMapper
import com.example.forum.users.domain.model.User
import com.example.forum.users.domain.port.CreateUserPort
import com.example.forum.users.domain.port.FindUserPort
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional(readOnly=true)
class UserRepositoryAdapter(
    private val repository: UserRepository,
    private val mapper: UserMapper
): CreateUserPort, FindUserPort {

    @Transactional
    override fun create(user: User): User {
        val entity = mapper.toEntity(user)
        val savedEntity = repository.save(entity)

        return mapper.toDomain(savedEntity)
    }

    override fun findByName(name: String) = this.repository
        .findByName(name)
        ?.let { mapper.toDomain(it) }
}