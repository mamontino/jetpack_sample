package com.andro.jetpack_sample.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.andro.domain.CountryInteractor
import com.andro.domain.EmployeeModel
import com.andro.domain.ServiceExcepcion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val interactor: CountryInteractor
) : ViewModel() {

    val countryList = interactor.getCountryList()

    val employee: List<EmployeeModel> = emptyList()

    fun getEmployeeList() {
        CoroutineScope(Dispatchers.IO).launch {
                withContext(Dispatchers.Main) {
                    try {
                        val data = interactor.getEmployeeList()
                    } catch (e: ServiceExcepcion) {
                        Log.e("", "")
                    } catch (e: Exception) {
                        Log.e("", "")
                    }
                }
        }
    }
}