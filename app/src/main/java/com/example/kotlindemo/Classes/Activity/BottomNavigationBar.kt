package com.example.kotlindemo.Classes.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlindemo.Classes.Fragment.HomeFragment
import com.example.kotlindemo.Classes.Fragment.SettingFragment
import com.example.kotlindemo.R
import com.example.kotlindemo.databinding.ActivityBottomNavigationBinding
import com.example.kotlindemo.databinding.ActivityNavigationdrawerBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationBar : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavigationBinding
//    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        loadFragment(HomeFragment())
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
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