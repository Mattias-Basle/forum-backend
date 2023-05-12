package com.example.forum.users.adapter.repository.jpa.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "users")
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val uuid: UUID,

    val name: String,

    val password: String,

    @Column(name="created_at")
    val createdAt: LocalDateTime,

    @Column(name="updated_at")
    val updatedAt: LocalDateTime
)
