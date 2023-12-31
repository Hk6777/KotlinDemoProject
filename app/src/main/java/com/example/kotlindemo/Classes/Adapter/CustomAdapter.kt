package com.example.kotlindemo.Classes.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemo.databinding.CardViewDesignBinding

class CustomAdapter(private val mList: ArrayList<String>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var listener: ((String) -> Unit)? = null
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val binding = CardViewDesignBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        // sets the image to the imageview from our itemHolder class
//        holder.binding.imageview.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.binding.textView.text = mList.get(position)

        holder.binding.cvClick.setOnClickListener {
            listener?.invoke(position.toString())
        }

    }


    fun setOnItemClickListener(f: (String) -> Unit) {
        listener = f

    }


    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ViewHolder(val binding: CardViewDesignBinding)
        :RecyclerView.ViewHolder(binding.root)
    // Holds the views for adding it to image and text

}