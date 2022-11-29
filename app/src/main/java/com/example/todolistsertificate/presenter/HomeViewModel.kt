package com.example.todolistsertificate.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistsertificate.data.models.ResultData
import com.example.todolistsertificate.data.models.response.AllTaskResponseData
import com.example.todolistsertificate.data.models.response.TaskPayload
import com.example.todolistsertificate.domain.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class HomeViewModel(private val mainRepository: MainRepository): ViewModel() {

//    private val _homeSuccessFlow = MutableSharedFlow<AllTaskResponseData>()
//    val homeSuccessFlow: Flow<AllTaskResponseData> get() = _homeSuccessFlow

    val successFlow = MutableSharedFlow<AllTaskResponseData>()

    fun getAllTodo() {
        mainRepository.getAllTodo().onEach {
            when (it) {
                is ResultData.Success -> {
                    successFlow.emit(it.data)
                }
                is ResultData.Message -> {
                }
                is ResultData.Error -> {

                }
            }
        }.launchIn(viewModelScope)
    }
}

