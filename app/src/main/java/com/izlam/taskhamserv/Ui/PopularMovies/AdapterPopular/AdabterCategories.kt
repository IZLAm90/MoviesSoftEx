package com.izlam.taskhamserv.Ui.PopularMovies.AdapterPopular

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.izlam.taskhamserv.Models.Genre
import com.izlam.taskhamserv.Models.Results
import com.izlam.taskhamserv.R
import com.izlam.taskhamserv.databinding.ItemGenresBinding

class AdabterCategories: RecyclerView.Adapter<AdabterCategories.CateGoriesViewHolder>() {
    lateinit var binding:ItemGenresBinding
    var cateData = arrayListOf<Genre>()


    inner class CateGoriesViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val name :TextView by lazy { itemView.findViewById(R.id.cate_name) }
        fun bindView(model :Genre){
            name.text=model.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CateGoriesViewHolder {
        binding= ItemGenresBinding.inflate(LayoutInflater.from(parent.context))
        return CateGoriesViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CateGoriesViewHolder, position: Int) {
        holder.bindView(cateData[position])
    }

    override fun getItemCount(): Int =cateData.size

    fun setDataFirstTime(items: List<Genre>) {
        this.cateData.clear()
        this.cateData.addAll(items)
        notifyDataSetChanged()
    }

}