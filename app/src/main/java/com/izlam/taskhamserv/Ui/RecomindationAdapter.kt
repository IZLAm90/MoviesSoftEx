package com.izlam.taskhamserv.Ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.izlam.taskhamserv.Models.Results
import com.izlam.taskhamserv.R
import com.izlam.taskhamserv.databinding.ActorsBinding
import com.izlam.taskhamserv.databinding.MoviesItemBinding
import com.izlam.taskhamserv.utils.Constant

class RecomindationAdapter : RecyclerView.Adapter<RecomindationAdapter.RecomindationHolder>(){
    lateinit var binding: ActorsBinding
    var onClickListener: ((Int, Results) -> Unit)? = null
    var onClickListenerREsults: ((Int, Results) -> Unit)? = null
    var MoviesData = arrayListOf<Results>()
    private val options : RequestOptions by lazy {
        RequestOptions.centerCropTransform()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .priority(Priority.HIGH)
    }
    inner class RecomindationHolder(itemView : View) :RecyclerView.ViewHolder(itemView){
        val poster: ImageView by lazy { itemView.findViewById(R.id.actor_image) }
        val Title: TextView by lazy { itemView.findViewById(R.id.actor_name) }

        fun bindData(movie:Results){
            Title.text=movie.original_title
            Log.d("islam", "bindData: ${movie.backdrop_path}")
            Glide.with(poster).load(Constant.BASE_URL_IMG+movie.backdrop_path)
                .thumbnail(0.01f)
                .apply(options)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecomindationHolder {
        binding=ActorsBinding.inflate(LayoutInflater.from(parent.context))
        return RecomindationHolder(binding.root)
    }

    override fun onBindViewHolder(holder: RecomindationHolder, position: Int) {
        holder.bindData(MoviesData[position])
    }

    override fun getItemCount(): Int {
        return MoviesData.size
    }

    fun setDataFirstTime(items: List<Results>) {
        this.MoviesData.clear()
        Log.d("islam", "setDataFirstTime: ${items.size}")
        this.MoviesData.addAll(items)
        Log.d("islam", "setDataFirstTime: ${MoviesData.size}")
        notifyDataSetChanged()
    }
    fun UpdateData(itmes:List<Results>){
        val last =MoviesData.size
        MoviesData.addAll(last,itmes)
        notifyDataSetChanged()
    }

}