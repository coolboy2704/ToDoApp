package com.example.todolistsertificate.data.remote

import com.example.todolistsertificate.data.models.request.LoginData
import com.example.todolistsertificate.data.models.request.RegisterData
import com.example.todolistsertificate.data.models.response.LoginResponseData
import retrofit2.Response
import retrofit2.http.Body
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
}
