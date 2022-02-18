package com.andro.data

import com.andro.domain.error.Error
import com.andro.domain.error.ErrorHandler
import javax.inject.Inject

class ErrorHandlerImpl @Inject constructor(private val errorMapper: ErrorMapper) : ErrorHandler {
    override fun getError(errorCode: Int): Error {
        return Error(code = errorCode, description = errorMapper.errorsMap.getValue(errorCode))
    }
}
