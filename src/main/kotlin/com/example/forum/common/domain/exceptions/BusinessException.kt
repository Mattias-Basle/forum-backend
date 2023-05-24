package com.example.forum.common.domain.exceptions

import com.example.forum.common.domain.enums.BusinessExceptions
import java.util.UUID

abstract class BusinessException (val type: BusinessExceptions, val uuid: UUID? = null) : RuntimeException(
    type.message + uuid?.let { it }
)