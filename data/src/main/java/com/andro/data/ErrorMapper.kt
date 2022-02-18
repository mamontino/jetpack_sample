package com.andro.data

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ErrorMapper @Inject constructor(@ApplicationContext val context: Context) : ErrorMapperSource {

    override fun getErrorString(errorId: Int): String =
        context.getString(errorId)

    override val errorsMap: Map<Int, String>
        get() = mapOf(
            Pair(com.andro.domain.error.NO_INTERNET_CONNECTION, getErrorString(R.string.network_error)),
            Pair(com.andro.domain.error.NETWORK_ERROR, getErrorString(R.string.network_error)),
            Pair(com.andro.domain.error.PASS_WORD_ERROR, getErrorString(R.string.network_error)),
            Pair(com.andro.domain.error.USER_NAME_ERROR, getErrorString(R.string.network_error)),
            Pair(com.andro.domain.error.CHECK_YOUR_FIELDS, getErrorString(R.string.network_error)),
            Pair(com.andro.domain.error.SEARCH_ERROR, getErrorString(R.string.network_error))
        ).withDefault { getErrorString(R.string.network_error) }
}
