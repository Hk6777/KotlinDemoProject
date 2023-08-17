package com.example.kotlindemo.JetPackComposed.Activity

import androidx.compose.ui.text.input.TextFieldValue

object Validation {

    fun isValidEmail(email: TextFieldValue): Boolean {
        val emailRegex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
        return emailRegex.matches(email.text)
    }

    fun isValidPassword(password: TextFieldValue): Boolean {
        return password.text.length >= 6 // Example: Password must be at least 6 characters
    }
}