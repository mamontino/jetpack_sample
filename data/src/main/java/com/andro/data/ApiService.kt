package com.andro.data

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("employees")
    suspend fun getEmployees(): Response<List<EmployeeResponse>>
}

class EmployeeResponse {
    val id: Int = 0
}