package com.andro.data

import com.andro.domain.ApiRepository
import com.andro.domain.EmployeeModel
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val employeeModelMapper: EmployeeModelMapper
) : ApiRepository, BaseRepository() {

    override suspend fun getEmployees(): List<EmployeeModel> = safeApiCall(
        call = { apiService.getEmployeesAsync().await() },
        error = "Error fetching news"
    ).map {
        employeeModelMapper(it)
    }
}