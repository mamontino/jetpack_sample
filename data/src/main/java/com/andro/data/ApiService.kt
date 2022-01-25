package com.andro.data

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("employees")
    suspend fun getEmployeesAsync(): Deferred<Response<List<EmployeeResponse>>>
}

class EmployeeResponse {
    val id: Int = 0
}