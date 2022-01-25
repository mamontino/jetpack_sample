package com.andro.data

import android.util.Log
import com.andro.domain.ServiceExcepcion
import retrofit2.Response

open class BaseRepository {
    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, error: String): T {
        val result = newsApiOutput(call, error)
        var output: T? = null
        when (result) {
            is Output.Success -> output = result.output
            is Output.Error -> Log.e("Error", "The $error and the ${result.exception}")
        }
        return output ?: throw ServiceExcepcion(id = 0, "Bad response")

    }

    private suspend fun <T : Any> newsApiOutput(call: suspend () -> Response<T>, error: String): Output<T> {
        val response = call.invoke()
        return if (response.isSuccessful) {
            Output.Success(response.body() ?: throw ServiceExcepcion(id = 0, "Bad response"))
        } else {
            Output.Error(ServiceExcepcion(id = 0, "Bad response"))
        }
    }
}