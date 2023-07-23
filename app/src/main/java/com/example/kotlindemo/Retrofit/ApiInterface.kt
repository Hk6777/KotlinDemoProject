package com.example.kotlindemo.Retrofit

import com.example.kotlindemo.model.LoginData
import com.example.kotlindemo.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @POST("login")
    suspend fun loginUser(@Body loginRequest: LoginData): Response<LoginResponse>

    companion object {
        fun getApi(): ApiInterface? {
            return  RetrofitClient.client?.create(ApiInterface::class.java)
        }
    }
}