package com.example.forum.users.domain.port

import com.example.forum.users.domain.model.User

interface CreateUserPort {

    fun create(user: User): User
}