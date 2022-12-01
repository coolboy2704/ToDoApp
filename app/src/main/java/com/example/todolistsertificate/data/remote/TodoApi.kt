package com.example.todolistsertificate.data.remote

import com.example.todolistsertificate.data.models.request.LoginData
import com.example.todolistsertificate.data.models.request.RegisterData
import com.example.todolistsertificate.data.models.request.TaskData
import com.example.todolistsertificate.data.models.response.AllTaskResponseData
import com.example.todolistsertificate.data.models.response.LoginResponseData
import com.example.todolistsertificate.data.models.response.TaskResponseData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface TodoApi {
    @POST("/api/register")
    suspend fun registerUser(
        @Body user: RegisterData
    ): Response<LoginResponseData>

    @POST("/api/login")
    suspend fun login(
        @Body user: LoginData
    ): Response<LoginResponseData>

    @POST("/api/tasks")
    suspend fun createTodo(
        @Body todo: TaskData
    ): Response<TaskResponseData>

    @GET("/api/tasks")
    suspend fun getAllTodo(
//        @Header("Authorization") token: String,
    ): Response<AllTaskResponseData>
}
