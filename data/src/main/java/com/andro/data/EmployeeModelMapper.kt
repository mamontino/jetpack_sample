package com.andro.data

import com.andro.domain.EmployeeModel
import javax.inject.Inject

class EmployeeModelMapper @Inject constructor() {

    operator fun invoke(employeeResponse: EmployeeResponse): EmployeeModel {
        return EmployeeModel(
            id = employeeResponse.id
        )
    }
}