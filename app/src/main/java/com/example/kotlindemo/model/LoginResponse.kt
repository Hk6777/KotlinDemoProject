package com.example.kotlindemo.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("_id")
    var id: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("username")
    var username: String
)

