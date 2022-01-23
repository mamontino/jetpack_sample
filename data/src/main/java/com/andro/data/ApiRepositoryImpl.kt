package com.andro.data

import com.andro.domain.ApiRepository
import com.andro.domain.EmployeeModel
import com.andro.domain.ServiceExcepcion
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val employeeModelMapper: EmployeeModelMapper
) : ApiRepository {

    override suspend fun getEmployees(): List<EmployeeModel> {
        val response = apiService.getEmployees()
        if (response.isSuccessful) {
            return response.body()!!.map {
                employeeModelMapper(it)
            }
        } else {
            throw ServiceExcepcion(0, "bb")
        }
    }
}