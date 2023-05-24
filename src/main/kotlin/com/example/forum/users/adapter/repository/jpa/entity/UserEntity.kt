package com.example.forum.users.adapter.repository.jpa.entity

import jakarta.persistence.*
import org.hibernate.annotations.Type
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "users")
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "uuid", unique = true, updatable = false, columnDefinition = "UUID NOT NULL")
    val uuid: UUID,

    val name: String,

    val password: String,

    @Column(name="created_at")
    val createdAt: LocalDateTime,

    @Column(name="updated_at")
    val updatedAt: LocalDateTime
)
