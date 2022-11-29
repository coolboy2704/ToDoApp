package com.example.todolistsertificate.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistsertificate.data.models.ResultData
import com.example.todolistsertificate.data.models.request.LoginData
import com.example.todolistsertificate.domain.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class LoginViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val _loginSuccessFlow = MutableSharedFlow<Int>()
    val loginSuccessFlow: Flow<Int> get() = _loginSuccessFlow

    fun login(phone: String, password: String) {
        mainRepository.login(LoginData(phone, password)).onEach {
            loaderFlow.emit(true)
            when (it) {
                is ResultData.Success -> {
                    _loginSuccessFlow.emit(it.data.code)
                }
                is ResultData.Message -> {
                    messageFlow.emit(it.message)
                }
                is ResultData.Error -> {
                    errorFlow.emit(it.error)
                }
            }
            loaderFlow.emit(false)
        }.launchIn(viewModelScope)
    }

    val errorFlow = MutableSharedFlow<Throwable>()
    val loaderFlow = MutableSharedFlow<Boolean>()
    val messageFlow = MutableSharedFlow<String>()


}

