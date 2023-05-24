package com.example.forum.common.adapter.controller.handler

import com.example.forum.common.domain.exceptions.BusinessException
import com.example.forum.users.domain.exceptions.UserNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(exception: BusinessException): ResponseEntity<Error> {
        val error = Error(exception.type.code, exception.type.message)

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error)
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(exception: UserNotFoundException): ResponseEntity<Error> {
        val error = Error(exception.type.code, exception.type.message)

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(error)
    }


}