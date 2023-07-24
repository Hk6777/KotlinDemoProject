package com.example.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.kotlindemo.Retrofit.SessionManager
import com.example.kotlindemo.databinding.ActivityLoginBinding
import com.example.kotlindemo.databinding.ActivityMainBinding
import com.example.kotlindemo.model.LoginResponse
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.button2.setOnClickListener {
            val i = Intent(this, DiceRollActivity::class.java)
            startActivity(i)
        }

        binding.btnLogin.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }


    }


}


