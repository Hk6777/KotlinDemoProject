package com.example.kotlindemo.JetPackComposed.SigninSignup

import javax.annotation.concurrent.Immutable

sealed class User{
    @Immutable
    data class LogedInUser(val email:String) : User()
    object GuestUser: User()
    object NoUserLogedIn : User()

}

object UserRepository{
    private var _user: User = User.NoUserLogedIn
    val user: User
        get() = _user

    @Suppress("UNUSED_PARAMETER")
    fun signIn(email: String,password:String){
        _user= User.LogedInUser(email)
    }
    @Suppress("UNUSED_PARAMETER")
    fun signUp(email: String, password: String) {
        _user = User.LogedInUser(email)
    }

    fun signInGuest(){
        _user = User.GuestUser
    }

    fun isKnownUserEmail(email : String): Boolean{
        return !email.contains("signup")
    }

}