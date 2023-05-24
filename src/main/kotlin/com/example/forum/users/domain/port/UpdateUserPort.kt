package com.example.forum.users.domain.port

import com.example.forum.users.domain.model.User

interface UpdateUserPort {

    fun updateUserPassword(user: User): User
}