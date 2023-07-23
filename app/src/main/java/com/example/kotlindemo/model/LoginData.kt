package com.example.kotlindemo.model

import com.google.gson.annotations.SerializedName

data class LoginData(
    @SerializedName("username")
    var username: String,
    @SerializedName("password")
    var password: String,

)
