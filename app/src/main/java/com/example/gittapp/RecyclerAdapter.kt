package com.example.gittapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_screen.view.*

class RecyclerAdapter(private val recyclerList: List<RecyclerItem>, var clickListener: onItemClickListener): RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {
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
       /* holder.userImage1.setImageResource(currentItem.imageResource1)
        holder.followers.text = currentItem.text1
        holder.userName.text = currentItem.text2*/
        holder.initialize(recyclerList.get(position), clickListener)
    }

    class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val userImage1: ImageView = itemView.user_image
        val followers: TextView = itemView.follower
        val userName : TextView = itemView.username

        fun initialize(item : RecyclerItem, action : onItemClickListener){
            userImage1.setImageResource(item.imageResource1)
            followers.text = item.text1
            userName.text = item.text2

            itemView.setOnClickListener{
                action.onItemClick(item,adapterPosition)
            }
        }

    }
   
}
interface onItemClickListener{
    fun onItemClick(item : RecyclerItem, position: Int)
}