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

class LiveStreamAdapter(mylist :List<live_streamsModel>, context: Context): RecyclerView.Adapter<LiveStreamAdapter.LiveStreamHolder>() {
    var list=mylist
    var context=context
    class LiveStreamHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val ic_stream: ImageView = itemView.findViewById(R.id.ic_stream)
        val title: TextView = itemView.findViewById(R.id.title)
        val category_id: TextView = itemView.findViewById(R.id.category_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveStreamHolder {
        return LiveStreamHolder(  LayoutInflater.from(parent.context).inflate(R.layout.row_livestream, parent, false))
    }

    override fun onBindViewHolder(holder: LiveStreamHolder, position: Int) {
        Glide.with(context).load(list[position].stream_icon).placeholder(R.drawable.ic_add).into(holder.ic_stream)
        holder.title.text = list[position].name
        holder.category_id.text=list[position].category_id
    }

    override fun getItemCount(): Int {
        return list.size
    }
}