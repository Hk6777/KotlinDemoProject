package com.example.kotlindemo.Classes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlindemo.Classes.Activity.BottomNavigationBar
import com.example.kotlindemo.Classes.Activity.DatePicker
import com.example.kotlindemo.Classes.Activity.DialogBoxActivity
import com.example.kotlindemo.Classes.Activity.NavigationActivity
import com.example.kotlindemo.Classes.Adapter.CustomAdapter
import com.example.kotlindemo.databinding.ActivityAllcalssisBinding

class AllClassesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAllcalssisBinding
    val classList: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllcalssisBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        addData()
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
//        val data = ArrayList<ItemsViewModel>()


        // This loop will create 20 Views containing
        // the image with the count of view
//        for (i in 1..20) {
//            data.add(ItemsViewModel(R.drawable.baseline_class_24, "Item " + i))
//        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(classList)


        adapter.setOnItemClickListener {
            println(it)
            when(it){
                "0" -> {startActivity(Intent(this, DatePicker::class.java))}
                "1" -> {startActivity(Intent(this, NavigationActivity::class.java))}
                "2" -> {startActivity(Intent(this, BottomNavigationBar::class.java))}
                "3" -> {startActivity(Intent(this, DialogBoxActivity::class.java))}
                else->{}
            }


        }

        // Setting the Adapter with the recyclerview
        binding.recyclerview.adapter = adapter

    }

    private fun addData() {
        classList.add("Date Picker")
        classList.add("Navigation Activity")
        classList.add("Bottom Navigation Bar")
        classList.add("Dialog Box")
    }
}