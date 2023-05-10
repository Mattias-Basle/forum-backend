package com.example.forum.users.adapter.repository.jpa.mapper

import com.example.forum.users.adapter.repository.jpa.entity.UserEntity
import com.example.forum.users.domain.model.User
import org.mapstruct.Mapper

@Mapper
interface UserMapper {

    fun toDomain(entity: UserEntity): User

    fun toEntity(model: User): UserEntity
}