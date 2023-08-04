package com.example.firebaservrealdbk.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlindemo.SampleApp.BlogappwithFirebase.BlogDetailActivity
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
        val context = holder.itemView.context;

        holder.binding.idTxtTitle.text = currentitem.blogtitle
        holder.binding.idtxtAuther.text = currentitem.blogauther

        Glide.with(context)
            .load(currentitem.blogimageurl)
            .into(holder.binding.idIvImage)



        holder.binding.cvClick.setOnClickListener {
            val intent = Intent(context, BlogDetailActivity::class.java)
            intent.putExtra("title",currentitem.blogtitle)
            intent.putExtra("auther",currentitem.blogauther)
            intent.putExtra("detail",currentitem.blogdetail)
            intent.putExtra("image",currentitem.blogimageurl)
            context.startActivity(intent)
        }




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