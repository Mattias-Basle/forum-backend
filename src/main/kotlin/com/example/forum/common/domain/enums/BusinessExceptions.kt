package com.example.forum.common.domain.enums

enum class BusinessExceptions(val code: Int,val message: String) {
    USER_ALREADY_EXIST(4000, "The name provided already exists."),
    USER_NOT_FOUND(4001, "The user was not found")
}