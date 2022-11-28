package com.example.todolistsertificate.domain.impl

import com.example.todolistsertificate.data.models.ResultData
import com.example.todolistsertificate.data.models.request.RegisterData
import com.example.todolistsertificate.data.models.response.LoginResponseData
import com.example.todolistsertificate.data.remote.TodoApi
import com.example.todolistsertificate.domain.MainRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(val api: TodoApi) : MainRepository {
    override fun register(user: RegisterData) = flow<ResultData<LoginResponseData>>{
        val response = api.registerUser(user)
        if (response.isSuccessful){
            emit(ResultData.Success(response.body()!!))
        } else {
            emit(ResultData.Message("Error register"))
        }
    }.catch {
        emit(ResultData.Error(it))
    }
}