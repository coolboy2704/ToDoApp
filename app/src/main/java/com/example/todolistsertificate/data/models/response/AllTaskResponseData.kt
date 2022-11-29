package com.example.todolistsertificate.data.models.response

import com.google.gson.annotations.SerializedName

data class AllTaskResponseData(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("payload")
    val payload: List<TaskPayload>
)



