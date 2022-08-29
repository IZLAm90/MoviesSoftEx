package com.izlam.taskhamserv.Ui.PopularMovies.AdapterPopular

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.izlam.taskhamserv.Models.Results
import com.izlam.taskhamserv.R
import com.izlam.taskhamserv.Ui.PopularMovies.AdapterPopular.AdapterPop.PopUlarHolder
import com.izlam.taskhamserv.databinding.MoviesItemBinding
import com.izlam.taskhamserv.utils.Constant
import de.hdodenhof.circleimageview.CircleImageView

class AdapterPop : RecyclerView.Adapter<PopUlarHolder>() {
    lateinit var binding:MoviesItemBinding
    var onClickListener: ((Int, Results) -> Unit)? = null
    var MoviesData = arrayListOf<Results>()
    private val options :RequestOptions by lazy {
        RequestOptions.centerCropTransform()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .priority(Priority.HIGH)
    }
  inner class PopUlarHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val poster: ImageView by lazy { itemView.findViewById(R.id.postar_img) }
        val Title:TextView by lazy { itemView.findViewById(R.id.title) }
        val rate:TextView by lazy { itemView.findViewById(R.id.rate) }
        val moviesLayout: CardView by lazy { itemView.findViewById(R.id.moviesLayout) }
        fun bindData(movie:Results){
            Title.text=movie.title
            rate.text= "${movie.popularity} "
            Glide.with(poster).load(Constant.BASE_URL_IMG+movie.poster_path)
                .thumbnail(0.01f)
                .apply(options)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(poster)

            moviesLayout.setOnClickListener{
                onClickListener?.invoke(absoluteAdapterPosition,movie)
            }
        }

    }
    fun setDataFirstTime(items: List<Results>) {
        this.MoviesData.clear()
        this.MoviesData.addAll(items)
        notifyDataSetChanged()
    }
    fun filterSearch(item : Results){
        MoviesData.add(item)
        notifyDataSetChanged()
    }
    fun clearData(){
        MoviesData.clear()
    }

    fun UpdateData(itmes:List<Results>){
      //  this.MoviesData.addAll(itmes)
        val last =MoviesData.size
        MoviesData.addAll(last,itmes)
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