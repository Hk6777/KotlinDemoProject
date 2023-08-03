package com.example.kotlindemo.SampleApp.BlogappwithFirebase.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlindemo.SampleApp.BlogappwithFirebase.Model.BlogData
import com.example.kotlindemo.databinding.CardViewDesignBinding
import com.example.kotlindemo.databinding.ItemBloglistBinding
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class BlogDataAdapter(private val mList: FirebaseRecyclerOptions<BlogData>
) :
    FirebaseRecyclerAdapter<BlogData, BlogDataAdapter.ViewHolder>(mList) {

    private var listener: ((String) -> Unit)? = null

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val binding = ItemBloglistBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: BlogData) {


        // sets the image to the imageview from our itemHolder class
//        holder.binding.imageview.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
//        holder.binding.textView.text = mList.get(position)

        holder.binding.idTxtTitle.text = model.blogtitle
        holder.binding.idtxtAuther.text = model.blogauther

        Glide.with(holder.itemView.context)
            .load(model.blogimageurl)
            .into(holder.binding.idIvImage);

//        holder.binding.cvClick.setOnClickListener {
//            listener?.invoke(position.toString())
//        }

    }


    // return the number of the items in the list
//    override fun getItemCount(): Int {
//        return mList.size
//    }

    inner class ViewHolder(val binding: ItemBloglistBinding) :
        RecyclerView.ViewHolder(binding.root)
    // Holds the views for adding it to image and text

}