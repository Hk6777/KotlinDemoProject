package com.example.kotlindemo.Classes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlindemo.Classes.Adapter.CustomAdapter
import com.example.kotlindemo.MainActivity
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
            val number  = readLine()!!.toInt()
            when(number){
                0 -> {startActivity(Intent(this, MainActivity::class.java))}
                1 -> {startActivity(Intent(this, MainActivity::class.java))}
                else->{}
            }


        }

        // Setting the Adapter with the recyclerview
        binding.recyclerview.adapter = adapter

    }

    private fun addData() {
        classList.add("dog")
        classList.add("cat")
        classList.add("owl")
        classList.add("cheetah")
        classList.add("raccoon")
    }
}