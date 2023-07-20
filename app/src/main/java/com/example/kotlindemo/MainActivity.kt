package com.example.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diceroll: Button = findViewById(R.id.button2)
        val btnLogin: Button = findViewById(R.id.btnLogin)

        diceroll.setOnClickListener{
            val i = Intent(this, DiceRollActivity::class.java)
            startActivity(i)
        }

        btnLogin.setOnClickListener{
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }

        val subclass: Button = findViewById(R.id.button3)


    }


}