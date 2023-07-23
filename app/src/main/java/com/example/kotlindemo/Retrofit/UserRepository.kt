package com.example.kotlindemo.Retrofit

import com.example.kotlindemo.model.LoginData
import com.example.kotlindemo.model.LoginResponse
import retrofit2.Response

class UserRepository {

    suspend fun loginUser(loginRequest:LoginData): Response<LoginResponse>? {
        return  ApiInterface.getApi()?.loginUser(loginRequest = loginRequest)
    }
}