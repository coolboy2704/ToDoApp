package com.example.todolistsertificate.presenter

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistsertificate.data.models.ResultData
import com.example.todolistsertificate.data.models.response.AllTaskResponseData
import com.example.todolistsertificate.data.models.response.TaskPayload
import com.example.todolistsertificate.domain.MainRepository
import com.example.todolistsertificate.ui.adapters.TaskAdapter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class HomeViewModel(private val mainRepository: MainRepository): ViewModel() {


//    private val _homeSuccessFlow = MutableSharedFlow<AllTaskResponseData>()
//    val homeSuccessFlow: Flow<AllTaskResponseData> get() = _homeSuccessFlow

    val successFlow = MutableSharedFlow<AllTaskResponseData>()
    val loaderFlow = MutableSharedFlow<Boolean>()

    fun getAllTodo(adapter: TaskAdapter, recyclerView: RecyclerView) {
        mainRepository.getAllTodo().onEach {
            loaderFlow.emit(true)
            when (it) {
                is ResultData.Success -> {
                    adapter.model = it.data.payload.toMutableList()
                    successFlow.emit(it.data)
                }
                is ResultData.Message -> {
                }
                is ResultData.Error -> {

                }
            }
            loaderFlow.emit(false)
        }.launchIn(viewModelScope)
    }
}

