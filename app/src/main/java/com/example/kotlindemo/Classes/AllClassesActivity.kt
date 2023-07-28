package com.example.kotlindemo.Classes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlindemo.Classes.Adapter.CustomAdapter
import com.example.kotlindemo.Classes.Model.ItemsViewModel
import com.example.kotlindemo.R
import com.example.kotlindemo.databinding.ActivityAllcalssisBinding

class AllClassesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAllcalssisBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllcalssisBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(ItemsViewModel(R.drawable.baseline_class_24, "Item " + i))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        binding.recyclerview.adapter = adapter

    }
}