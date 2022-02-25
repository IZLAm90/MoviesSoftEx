package com.izlam.taskhamserv.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.izlam.taskhamserv.Models.ModelCategory
import com.izlam.taskhamserv.Models.live_streamsModel
import com.izlam.taskhamserv.R

class CategoryAdapter(myList: List<ModelCategory>): RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {
    var list=myList
    class CategoryHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val category_id: TextView = itemView.findViewById(R.id.category_id)
        val category_name: TextView = itemView.findViewById(R.id.category_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        return CategoryHolder( LayoutInflater.from(parent.context).inflate(R.layout.row_catogory, parent, false))
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.category_id.text = list[position].category_id.toString()
        holder.category_name.text = list[position].category_name as String

    }

    override fun getItemCount(): Int {
       return list.size
    }
}