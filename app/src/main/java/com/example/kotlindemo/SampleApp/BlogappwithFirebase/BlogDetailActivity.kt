package com.example.kotlindemo.SampleApp.BlogappwithFirebase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kotlindemo.databinding.ActivityBlogdetailBinding

class BlogDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlogdetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogdetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val title = intent.getStringExtra("title")
        val auther = intent.getStringExtra("auther")
        val detail = intent.getStringExtra("detail")
        val imageurl = intent.getStringExtra("image")


        binding.txtTitle.setText(title)
        binding.txtDetail.setText(detail)

        Glide.with(this)
            .load(imageurl)
            .into(binding.ivImage)



    }
}