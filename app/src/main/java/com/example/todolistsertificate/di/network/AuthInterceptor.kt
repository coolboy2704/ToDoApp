package com.example.todolistsertificate.di.network

import com.example.todolistsertificate.data.local.LocalStorage
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val localStorage: LocalStorage): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(
                "token",
                localStorage.token
            )
            .build()
        return chain.proceed(request)
    }
}