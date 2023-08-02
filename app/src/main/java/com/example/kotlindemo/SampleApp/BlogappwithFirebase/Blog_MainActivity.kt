package com.example.kotlindemo.SampleApp.BlogappwithFirebase

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlindemo.Classes.Fragment.HomeFragment
import com.example.kotlindemo.Classes.Fragment.SettingFragment
import com.example.kotlindemo.R
import com.example.kotlindemo.SampleApp.BlogappwithFirebase.Fragment.Blog_HomeFragment
import com.example.kotlindemo.databinding.ActivityBlogmainBinding


class Blog_MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlogmainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogmainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        loadFragment(Blog_HomeFragment())
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(Blog_HomeFragment())
                    true
                }

                R.id.message -> {
                    loadFragment(HomeFragment())
                    true
                }

                R.id.settings -> {
                    loadFragment(SettingFragment())
                    true
                }

                else -> {
                    println("false")
                    false
                }
            }
        }

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}