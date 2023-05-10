package com.example.forum.users.adapter.repository.jpa

import com.example.forum.users.adapter.repository.jpa.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<UserEntity, Long> {
}