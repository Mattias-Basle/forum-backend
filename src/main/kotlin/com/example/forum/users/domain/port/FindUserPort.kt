package com.example.forum.users.domain.port

import com.example.forum.users.domain.model.User

interface FindUserPort {

    fun findByName(name: String): User?
}