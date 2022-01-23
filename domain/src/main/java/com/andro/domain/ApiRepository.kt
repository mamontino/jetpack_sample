package com.andro.domain

interface ApiRepository {
    suspend fun getEmployees(): List<EmployeeModel>
}