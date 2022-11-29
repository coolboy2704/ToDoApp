package com.example.todolistsertificate.data.models.response

import com.google.gson.annotations.SerializedName

data class TaskResponseData(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("payload")
    val payload: TaskPayload
)

data class TaskPayload(
    @SerializedName("id")
    val id: Int,
    @SerializedName("task")
    val task: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("is_done")
    val isDone: Boolean
)

