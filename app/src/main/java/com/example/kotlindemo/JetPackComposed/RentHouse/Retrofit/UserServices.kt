package com.example.kotlindemo.JetPackComposed.RentHouse.Retrofit

import com.example.kotlindemo.JetPackComposed.RentHouse.Retrofit.Model.UserResponce
import com.example.kotlindemo.JetPackComposed.RentHouse.Retrofit.Model.User_Model
import retrofit2.http.GET

interface UserServices {
    @GET(User_Model.END_POINTS)
    suspend fun getUser(): List<UserResponce>
}