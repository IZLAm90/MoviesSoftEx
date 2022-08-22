package com.izlam.taskhamserv.Ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.izlam.taskhamserv.Ui.PopularMovies.AdapterPopular.AdapterPop
import com.izlam.taskhamserv.ViewModels.MovieViewModel
import com.izlam.taskhamserv.databinding.FragmentSingleMovieBinding
import com.izlam.taskhamserv.utils.Constant
import com.izlam.taskhamserv.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SingleMovieFragment : Fragment() {
lateinit var binding:FragmentSingleMovieBinding
private val Viewmodel:MovieViewModel by viewModels()
    private lateinit var movies_rv : RecyclerView
    private val adapter = RecomindationAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSingleMovieBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRVReco()
        arguments?.let {
            if (it !=null){
                val movie = it["movie"] as Int
                Viewmodel.getMovieById(movie)
                Viewmodel.getRecoMovie(movie)
            }
            setUpViewModel()
            getRcoData()
        }
    }

    fun setUpViewModel(){
        Viewmodel.movieResponse.observe(viewLifecycleOwner){
            when(it){
                is NetworkResult.Loading -> {
                    Timber.d("onCreate:Loading Loading")
                }
                is NetworkResult.Success -> {
                    Glide.with(binding.imgPlace).load(Constant.BASE_URL_IMG+"/5hNcsnMkwU2LknLoru73c76el3z.jpg")
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(binding.imgPlace)
                    Log.d("islam", "setUpViewModel: ${it.data}")
                    binding.titleName.text="Title : ${it.data.title}"
                    binding.overView.text="OverView : ${it.data.overview}"
                    binding.rate.text="Rating : ${it.data.popularity}"
                }
                is NetworkResult.Failure ->{
                    Timber.d("onCreate:Failure Failure")

                }
            }
        }
    }

    fun setRVReco(){
        movies_rv=binding.recomRv
        movies_rv.setHasFixedSize(false)
        movies_rv.layoutManager=LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        movies_rv.adapter=adapter
    }

    fun getRcoData(){
      Viewmodel.rmovieResponse.observe(viewLifecycleOwner){
          when(it){
              is NetworkResult.Loading ->{
                  Timber.d("onCreate:Loading Loading")
                  Log.d("islam", "getRcoData: ${it.isLoading}")
              }
              is NetworkResult.Success ->{
                  adapter.setDataFirstTime(it.data.results)
                  adapter.UpdateData(it.data.results)
                  Log.d("islam", "getRcoData: ${it.data.results}")
              }
              is NetworkResult.Failure->{
                  Timber.d("onCreate:Failure ${it.errorMessage}")
                  Log.d("islam", "getRcoData: ${it.errorMessage}")
              }
          }
      }

    }
}