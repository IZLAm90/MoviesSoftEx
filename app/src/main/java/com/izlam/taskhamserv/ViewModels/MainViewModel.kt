package com.izlam.taskhamserv.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.izlam.taskhamserv.Models.GenresModel
import com.izlam.taskhamserv.Models.TopRateMoviesModel
import com.izlam.taskhamserv.utils.NetworkResult
import com.izlam.taskhamserv.Repositorys.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*


import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor (private val repository: Repository): ViewModel() {

    private var _movieResponse = MutableLiveData<NetworkResult<TopRateMoviesModel>>()
    val movieResponse: LiveData<NetworkResult<TopRateMoviesModel>> = _movieResponse

    init {
        fetchAllMovies(1)
        getMoviesCategoris()
    }

    fun fetchAllMovies(page : Int) {
        viewModelScope.launch {
            repository.getPopularMovies(page).collect {
                _movieResponse.postValue(it)
            }
        }
    }


    private val _moviesList =MutableLiveData<NetworkResult<GenresModel>>()
    val moviesList :LiveData<NetworkResult<GenresModel>> =_moviesList

    fun getMoviesCategoris(){
        viewModelScope.launch {
            repository.getMoviesCategories().collect {
                Log.d("islam", "getMoviesCategoris: ${it}")
                _moviesList.postValue(it)
            }
        }
    }


}