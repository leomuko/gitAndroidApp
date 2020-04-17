package com.example.gittapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_screen.view.*

class RecyclerAdapter(private val recyclerList: List<RecyclerItem>): RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter.RecyclerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_screen,parent, false)
        return RecyclerViewHolder(itemView)
    }

    override fun getItemCount() = recyclerList.size

    override fun onBindViewHolder(holder: RecyclerAdapter.RecyclerViewHolder, position: Int) {
        val currentItem = recyclerList[position]
        holder.userImage1.setImageResource(currentItem.imageResource1)
        holder.userImage2.setImageResource(currentItem.imageResource2)
        holder.userName1.text = currentItem.text1
        holder.userName2.text = currentItem.text2
    }

    class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val userImage1: ImageView = itemView.user_image
        val userImage2: ImageView = itemView.user_image2
        val userName1: TextView = itemView.user_name
        val userName2 : TextView = itemView.user_name2
    }


}