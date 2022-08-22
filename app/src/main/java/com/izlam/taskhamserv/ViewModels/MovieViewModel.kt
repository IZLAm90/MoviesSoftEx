package com.izlam.taskhamserv.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.izlam.taskhamserv.Models.MovieModel
import com.izlam.taskhamserv.Models.Results
import com.izlam.taskhamserv.Models.TopRateMoviesModel
import com.izlam.taskhamserv.Repositorys.SingleMovieRepo
import com.izlam.taskhamserv.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepo: SingleMovieRepo) : ViewModel() {

    private var _singleMovieResponse = MutableLiveData<NetworkResult<MovieModel>>()
    val movieResponse: LiveData<NetworkResult<MovieModel>> = _singleMovieResponse
    var job: Job? = null

    fun getMovieById(id : Int){
        job = CoroutineScope(Dispatchers.IO).launch{
           movieRepo.getMovie(id).collect{
                _singleMovieResponse.postValue(it)
            }
        }
    }


    private var _recoMovieResponse = MutableLiveData<NetworkResult<TopRateMoviesModel>>()
    val rmovieResponse: LiveData<NetworkResult<TopRateMoviesModel>> = _recoMovieResponse

    fun getRecoMovie(id: Int){
        job = CoroutineScope(Dispatchers.IO).launch{
            movieRepo.getRecoMovie(id).collect{
                _recoMovieResponse.postValue(it)
            }
        }
    }

}