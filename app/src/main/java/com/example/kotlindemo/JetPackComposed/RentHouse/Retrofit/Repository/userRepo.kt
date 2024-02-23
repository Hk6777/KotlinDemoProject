package com.example.kotlindemo.JetPackComposed.RentHouse.Retrofit.Repository

import com.example.kotlindemo.JetPackComposed.RentHouse.Retrofit.Model.UserResponce
import com.example.kotlindemo.JetPackComposed.RentHouse.Retrofit.UserServices
import javax.inject.Inject

class userRepo @Inject constructor(
    private val userApi : UserServices
){
    suspend fun getuser():List<UserResponce>{
        return userApi.getUser()
    }
}
