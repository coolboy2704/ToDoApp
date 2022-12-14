package com.example.todolistsertificate.domain.impl

import android.media.session.MediaSession.Token
import com.example.todolistsertificate.data.local.LocalStorage
import com.example.todolistsertificate.data.models.ResultData
import com.example.todolistsertificate.data.models.request.LoginData
import com.example.todolistsertificate.data.models.request.RegisterData
import com.example.todolistsertificate.data.models.request.TaskData
import com.example.todolistsertificate.data.models.response.AllTaskResponseData
import com.example.todolistsertificate.data.models.response.LoginResponseData
import com.example.todolistsertificate.data.models.response.TaskResponseData
import com.example.todolistsertificate.data.remote.TodoApi
import com.example.todolistsertificate.domain.MainRepository
import kotlinx.coroutines.flow.Flow
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

    override fun login(user: LoginData)  = flow<ResultData<LoginResponseData>>{
        val response = api.login(user)
        if (response.isSuccessful){
            emit(ResultData.Success(response.body()!!))
        } else {
            emit(ResultData.Message("Error Login"))
        }
    }.catch {
        emit(ResultData.Error(it))
    }

    override fun createTodo(todo: TaskData)= flow<ResultData<TaskResponseData>>{
        val response = api.createTodo(todo)
        if (response.isSuccessful){
            emit(ResultData.Success(response.body()!!))
        } else {
            emit(ResultData.Message("Error Login"))
        }
    }.catch {
        emit(ResultData.Error(it))
    }



    override fun getAllTodo() = flow {
        val response = api.getAllTodo()
        if (response.isSuccessful){
            emit(ResultData.Success(response.body()!!))
        } else {
            emit(ResultData.Message("Error Login"))
        }
    }.catch {
        emit(ResultData.Error(it))
    }
}