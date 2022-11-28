package com.example.todolistsertificate.domain

import com.example.todolistsertificate.data.models.ResultData
import com.example.todolistsertificate.data.models.request.LoginData
import com.example.todolistsertificate.data.models.request.RegisterData
import com.example.todolistsertificate.data.models.response.LoginResponseData
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun register(
        user: RegisterData
    ): Flow<ResultData<LoginResponseData>>

    fun login(
        user: LoginData
    ): Flow<ResultData<LoginResponseData>>
}

