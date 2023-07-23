package com.example.kotlindemo.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("code")
    var code: Int,
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("id")
    var id: String,
) {
    data class Data(

        @SerializedName("_id")
        var id: String,
        @SerializedName("Name")
        var name: String,
        @SerializedName("username")
        var username: String
    )
}

