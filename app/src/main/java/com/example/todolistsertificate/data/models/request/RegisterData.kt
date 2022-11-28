package com.example.todolistsertificate.data.models.request

import com.google.gson.annotations.SerializedName

data class RegisterData(
    @SerializedName("phone")
    val phone: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String
)