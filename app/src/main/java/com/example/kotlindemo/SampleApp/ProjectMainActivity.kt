package com.example.kotlindemo.SampleApp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.DiceRollActivity
import com.example.kotlindemo.SampleApp.BlogappwithFirebase.Blog_MainActivity
import com.example.kotlindemo.databinding.ActivityProjectmainBinding

class ProjectMainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityProjectmainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectmainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnproject1.setOnClickListener {
            val i = Intent(this, Blog_MainActivity::class.java)
            startActivity(i)
        }
    }
}