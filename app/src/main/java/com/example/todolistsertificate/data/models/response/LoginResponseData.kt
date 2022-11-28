package com.example.todolistsertificate.data.models.response

import com.google.gson.annotations.SerializedName

data class LoginResponseData(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("payload")
    val payload: Payload
)

data class Payload(
    @SerializedName("name")
    val name: Boolean,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("token")
    val token: String,
)

