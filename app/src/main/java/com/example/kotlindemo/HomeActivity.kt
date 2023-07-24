package com.example.kotlindemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.Retrofit.SessionManager
import com.example.kotlindemo.databinding.ActivityHomeBinding
import com.example.kotlindemo.databinding.ActivityLoginBinding

class HomeActivity : AppCompatActivity(){

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val userName = intent.getStringExtra("userName")
        println(userName+"--")

        if(userName != null) binding.tvUser.setText(userName)

        binding.btnLogout.setOnClickListener{
            SessionManager.clearData(this)
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
        }
    }
}