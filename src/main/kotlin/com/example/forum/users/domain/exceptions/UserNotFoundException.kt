package com.example.forum.users.domain.exceptions

import com.example.forum.common.domain.enums.BusinessExceptions
import com.example.forum.common.domain.exceptions.BusinessException
import java.util.UUID

class UserNotFoundException(uuid: UUID?): BusinessException(
    BusinessExceptions.USER_NOT_FOUND, uuid
)