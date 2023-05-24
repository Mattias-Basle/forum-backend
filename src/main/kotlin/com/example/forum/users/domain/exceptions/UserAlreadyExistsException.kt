package com.example.forum.users.domain.exceptions

import com.example.forum.common.domain.enums.BusinessExceptions
import com.example.forum.common.domain.exceptions.BusinessException
import java.util.UUID

class UserAlreadyExistsException(uuid: UUID?): BusinessException(
    BusinessExceptions.USER_ALREADY_EXIST, uuid
)