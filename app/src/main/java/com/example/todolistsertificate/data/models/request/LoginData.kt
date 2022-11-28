package com.example.todolistsertificate.data.models.request

import com.google.gson.annotations.SerializedName

data class LoginData(
    @SerializedName("phone")
    val phone: String,
    @SerializedName("password")
    val password: String
)
