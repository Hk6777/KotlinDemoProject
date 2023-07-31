package com.example.kotlindemo.Classes.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.Classes.Adapter.ViewPagerAdapter
import com.example.kotlindemo.Classes.Fragment.HomeFragment
import com.example.kotlindemo.Classes.Fragment.SettingFragment
import com.example.kotlindemo.databinding.ActivityTabviewBinding

class TabViewActivity : AppCompatActivity() {


    private lateinit var binding: ActivityTabviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabviewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbar)

        // Initializing the ViewPagerAdapter
        val adapter = ViewPagerAdapter(supportFragmentManager)

        // add fragment to the list
        adapter.addFragment(HomeFragment(), "GeeksForGeeks")
        adapter.addFragment(SettingFragment(), "Code Chef")
        adapter.addFragment(HomeFragment(), "Leet Code")

        // Adding the Adapter to the ViewPager
        binding.viewPager.adapter = adapter

        // bind the viewPager with the TabLayout.
        binding.tabs.setupWithViewPager(binding.viewPager)

    }
}