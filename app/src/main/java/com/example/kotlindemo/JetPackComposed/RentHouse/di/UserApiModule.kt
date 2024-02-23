package com.example.kotlindemo.JetPackComposed.RentHouse.di

import com.example.kotlindemo.JetPackComposed.RentHouse.Retrofit.Model.User_Model
import com.example.kotlindemo.JetPackComposed.RentHouse.Retrofit.UserServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserApiModule {

    @Provides
    @Singleton
    fun provideApi(builder:Retrofit.Builder): UserServices{
        return builder
            .build()
            .create(UserServices::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(User_Model.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
    }
}