package com.andro.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.andro.domain.DataRepository
import com.andro.domain.Resource
import com.andro.domain.dto.login.LoginRequest
import com.andro.domain.dto.login.LoginResponse
import com.andro.domain.error.CHECK_YOUR_FIELDS
import com.andro.domain.error.ErrorHandler
import com.andro.domain.error.PASS_WORD_ERROR
import com.andro.domain.error.USER_NAME_ERROR
import com.andro.ui_common.base.BaseViewModel
import com.andro.ui_common.utils.RegexUtils.isValidEmail
import com.andro.ui_common.utils.SingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val dataRepository: DataRepository,
    private val errorHandler: ErrorHandler
) : BaseViewModel() {

    private val loginLiveDataPrivate = MutableLiveData<Resource<LoginResponse>>()
    val loginLiveData: LiveData<Resource<LoginResponse>> get() = loginLiveDataPrivate

    /** Error handling as UI **/

    private val showSnackBarPrivate = MutableLiveData<SingleEvent<Any>>()
    val showSnackBar: LiveData<SingleEvent<Any>> get() = showSnackBarPrivate

    private val showToastPrivate = MutableLiveData<SingleEvent<Any>>()
    val showToast: LiveData<SingleEvent<Any>> get() = showToastPrivate


    fun doLogin(userName: String, passWord: String) {
        val isUsernameValid = isValidEmail(userName)
        val isPassWordValid = passWord.trim().length > 4
        if (isUsernameValid && !isPassWordValid) {
            loginLiveDataPrivate.value = Resource.DataError(PASS_WORD_ERROR)
        } else if (!isUsernameValid && isPassWordValid) {
            loginLiveDataPrivate.value = Resource.DataError(USER_NAME_ERROR)
        } else if (!isUsernameValid && !isPassWordValid) {
            loginLiveDataPrivate.value = Resource.DataError(CHECK_YOUR_FIELDS)
        } else {
            viewModelScope.launch {
                loginLiveDataPrivate.value = Resource.Loading()
                dataRepository.doLogin(loginRequest = LoginRequest(userName, passWord)).collect {
                    loginLiveDataPrivate.value = it
                }
            }
        }
    }

    fun showToastMessage(errorCode: Int) {
        val error = errorHandler.getError(errorCode)
        showToastPrivate.value = SingleEvent(error.description)
    }
}
