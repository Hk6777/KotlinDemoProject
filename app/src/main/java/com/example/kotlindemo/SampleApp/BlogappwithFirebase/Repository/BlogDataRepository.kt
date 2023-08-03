package com.example.firebaservrealdbk.Repository

import androidx.lifecycle.MutableLiveData
import com.example.kotlindemo.SampleApp.BlogappwithFirebase.Model.BlogData
import com.google.firebase.database.*

class BlogDataRepository {

    private val databaseReference: DatabaseReference =
        FirebaseDatabase.getInstance().getReference("BlogData")

    @Volatile
    private var INSTANCE: BlogDataRepository? = null

    fun getInstance(): BlogDataRepository {
        return INSTANCE ?: synchronized(this) {

            val instance = BlogDataRepository()
            INSTANCE = instance
            instance
        }
    }


    fun loadBlogData(blogList: MutableLiveData<List<BlogData>>) {

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                try {

                    val _blogDataList: List<BlogData> = snapshot.children.map { dataSnapshot ->

                        dataSnapshot.getValue(BlogData::class.java)!!

                    }

                    blogList.postValue(_blogDataList)

                } catch (e: Exception) {

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })


    }

}