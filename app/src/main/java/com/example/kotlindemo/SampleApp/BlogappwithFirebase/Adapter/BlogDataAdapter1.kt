package com.example.firebaservrealdbk.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlindemo.SampleApp.BlogappwithFirebase.Adapter.BlogDataAdapter
import com.example.kotlindemo.SampleApp.BlogappwithFirebase.Model.BlogData
import com.example.kotlindemo.databinding.ItemBloglistBinding

class BlogDataAdapter1 : RecyclerView.Adapter<BlogDataAdapter1.ViewHolder>() {

    private val blogDataList = ArrayList<BlogData>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(
//            R.layout.user_item,
//            parent,false
//        )
//        return MyViewHolder(itemView)


        val binding = ItemBloglistBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentitem = blogDataList[position]


        holder.binding.idTxtTitle.text = currentitem.blogtitle
        holder.binding.idtxtAuther.text = currentitem.blogauther

        Glide.with(holder.itemView.context)
            .load(currentitem.blogimageurl)
            .into(holder.binding.idIvImage)


    }

    override fun getItemCount(): Int {
        return blogDataList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateUserList(userList: List<BlogData>) {

        this.blogDataList.clear()
        this.blogDataList.addAll(userList)
        notifyDataSetChanged()

    }


    inner class ViewHolder(val binding: ItemBloglistBinding) :
        RecyclerView.ViewHolder(binding.root)


}