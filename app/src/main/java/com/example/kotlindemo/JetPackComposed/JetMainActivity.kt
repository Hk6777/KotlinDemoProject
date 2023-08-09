package com.example.kotlindemo.JetPackComposed

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.JetPackComposed.ui.theme.KotlinDemoTheme

class JetMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KotlinDemoTheme {
                Navigation()
            }
        }
    }
}