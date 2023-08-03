package com.example.kotlindemo.SampleApp.BlogappwithFirebase.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebaservrealdbk.Repository.BlogDataRepository

class BlogDataViewmodel : ViewModel() {

    private val repository : BlogDataRepository
    private val _allBlogs = MutableLiveData<List<BlogData>>()
    val allUsers : LiveData<List<BlogData>> = _allBlogs


    init {

        repository = BlogDataRepository().getInstance()
        repository.loadBlogData(_allBlogs)

    }

}