package com.andro.domain.error

interface ErrorHandler {
    fun getError(errorCode: Int): Error
}
