package com.example.todolistsertificate.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistsertificate.data.models.ResultData
import com.example.todolistsertificate.data.models.request.RegisterData
import com.example.todolistsertificate.domain.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RegisterViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val _registerSuccessFlow = MutableSharedFlow<String>()
    val registerSuccessFlow: Flow<String> get() = _registerSuccessFlow

    val loaderFlow = MutableSharedFlow<Boolean>()

    fun register(name: String, phone: String, password: String) {
        mainRepository.register(RegisterData(phone, name, password)).onEach {
            loaderFlow.emit(true)
            if (it is ResultData.Success) {
                _registerSuccessFlow.emit(it.data.payload.token)
            }

            loaderFlow.emit(false)
        }.launchIn(viewModelScope)
    }

}

