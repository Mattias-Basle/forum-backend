package com.example.forum.common.adapter.controller.handler

import com.example.forum.common.domain.exceptions.BusinessException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(exception: BusinessException): ResponseEntity<Error> {
        val error = Error(exception.type.code, exception.type.message)

        return ResponseEntity
            .badRequest()
            .body(error)
    }
}