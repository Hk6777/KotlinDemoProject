package com.example.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlindemo.Classes.AllClassesActivity
import com.example.kotlindemo.Database.SqliteActivity
import com.example.kotlindemo.Google.MapActivity
import com.example.kotlindemo.databinding.ActivityMainBinding

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
        binding.btnmap.setOnClickListener {
            val i = Intent(this, MapActivity::class.java)
            startActivity(i)
        }
        binding.btnSqlite.setOnClickListener {
            val i = Intent(this, SqliteActivity::class.java)
            startActivity(i)
        }
        binding.btnClasses.setOnClickListener {
            val i = Intent(this, AllClassesActivity::class.java)
            startActivity(i)
        }


    }


}


