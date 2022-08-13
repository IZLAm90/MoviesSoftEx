package com.izlam.taskhamserv.Ui.PopularMovies.AdapterPopular

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.graphics.createBitmap
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.Option
import com.bumptech.glide.load.engine.DiskCacheStrategy
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
    var MoviesData:List<TopRateMoviesModel> = arrayListOf()
    private val option :RequestOptions by lazy {
        RequestOptions.centerCropTransform()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
    }
    class PopUlarHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var poster:CircleImageView=itemView.findViewById(R.id.postar_img)
        var Title:TextView=itemView.findViewById(R.id.title)

        fun bindData(movie:Results){
            Title.text=movie.title
            Glide.with(itemView.context).load(movie.poster_path).into(poster)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopUlarHolder {
        binding=MoviesItemBinding.inflate(LayoutInflater.from(parent.context))
        return PopUlarHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PopUlarHolder, position: Int) {

    }

    override fun getItemCount(): Int {
    return MoviesData.size
    }


}