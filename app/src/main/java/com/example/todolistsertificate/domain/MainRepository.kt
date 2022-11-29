package com.example.todolistsertificate.domain

import com.example.todolistsertificate.data.models.ResultData
import com.example.todolistsertificate.data.models.request.LoginData
import com.example.todolistsertificate.data.models.request.RegisterData
import com.example.todolistsertificate.data.models.request.TaskData
import com.example.todolistsertificate.data.models.response.AllTaskResponseData
import com.example.todolistsertificate.data.models.response.LoginResponseData
import com.example.todolistsertificate.data.models.response.TaskResponseData
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun register(
        user: RegisterData
    ): Flow<ResultData<LoginResponseData>>

    fun login(
        user: LoginData
    ): Flow<ResultData<LoginResponseData>>

    fun createTodo(
        todo: TaskData
    ): Flow<ResultData<TaskResponseData>>

    fun getAllTodo(

    ): Flow<ResultData<AllTaskResponseData>>
}

