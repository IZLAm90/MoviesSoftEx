package com.izlam.taskhamserv.Ui.PopularMovies.AdapterPopular

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.graphics.createBitmap
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.Option
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.izlam.taskhamserv.Models.Results
import com.izlam.taskhamserv.Models.TopRateMoviesModel
import com.izlam.taskhamserv.R
import com.izlam.taskhamserv.Ui.PopularMovies.AdapterPopular.AdapterPop.PopUlarHolder
import com.izlam.taskhamserv.databinding.MoviesItemBinding
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.coroutines.channels.ticker

class AdapterPop : RecyclerView.Adapter<PopUlarHolder>() {
    lateinit var binding:MoviesItemBinding
    var onClickListener: ((Int, Results) -> Unit)? = null
    var MoviesData:List<Results> = arrayListOf()
    private val options :RequestOptions by lazy {
        RequestOptions.centerCropTransform()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
    }
  inner class PopUlarHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val poster:CircleImageView by lazy { itemView.findViewById(R.id.postar_img) }
        val Title:TextView by lazy { itemView.findViewById(R.id.title) }
        val moviesLayout:LinearLayout by lazy { itemView.findViewById(R.id.moviesLayout) }
        fun bindData(movie:Results){
            Title.text=movie.title
            Glide.with(poster).load(movie.poster_path)
                .thumbnail(0.01f)
                .apply(options)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(poster)

            moviesLayout.setOnClickListener{
                onClickListener?.invoke(adapterPosition,movie)
            }
        }

    }
    fun setDataFirstTime(items: List<Results>) {
        this.MoviesData = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopUlarHolder {
        binding=MoviesItemBinding.inflate(LayoutInflater.from(parent.context))
        return PopUlarHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PopUlarHolder, position: Int) {

        holder.bindData(MoviesData[position])
    }

    override fun getItemCount(): Int {
    return MoviesData.size
    }


}