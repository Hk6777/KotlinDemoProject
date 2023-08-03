package com.example.kotlindemo.SampleApp.BlogappwithFirebase.Fragment

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebaservrealdbk.Adapter.BlogDataAdapter1
import com.example.kotlindemo.SampleApp.BlogappwithFirebase.AddBlogActivity
import com.example.kotlindemo.SampleApp.BlogappwithFirebase.Model.BlogData
import com.example.kotlindemo.SampleApp.BlogappwithFirebase.Model.BlogDataViewmodel
import com.example.kotlindemo.databinding.FragmentBloghomeBinding
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query


class Blog_HomeFragment : Fragment() {

    private var _binding: FragmentBloghomeBinding? = null
    var adapter: BlogDataAdapter1? = null
    private lateinit var viewModel : BlogDataViewmodel
//    var mbase: DatabaseReference? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBloghomeBinding.inflate(inflater, container, false)

        binding.idBtnAddData.setOnClickListener {
            val intent = Intent(activity, AddBlogActivity::class.java)
            activity?.startActivity(intent)
        }

//        mbase = FirebaseDatabase.getInstance().reference
//        binding.recycler1!!.layoutManager = LinearLayoutManager(activity)
//
//        val query: Query = FirebaseFirestore.getInstance()
//            .collection("chats")
//            .orderBy("timestamp")
//            .limit(50)
//
//        // query in the database to fetch appropriate data
//        val options: FirebaseRecyclerOptions<BlogData> = FirebaseRecyclerOptions.Builder<BlogData>()
//            .setQuery(query, BlogData::class.java)
//            .build()
//        adapter = BlogDataAdapter(options)
//        binding.recycler1!!.adapter = adapter



        binding.recycler1.layoutManager = LinearLayoutManager(context)
        binding.recycler1.setHasFixedSize(true)
        adapter = BlogDataAdapter1()
        binding.recycler1.adapter = adapter

        viewModel = ViewModelProvider(this).get(BlogDataViewmodel::class.java)

        viewModel.allUsers.observe(viewLifecycleOwner, Observer {

            adapter!!.updateUserList(it)

        })
        Log.e(TAG, "onCreateView: "+"dddd" )

        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}


