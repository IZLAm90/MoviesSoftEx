package com.izlam.taskhamserv.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
        fetchAllMovies()
    }

    private fun fetchAllMovies() {
        viewModelScope.launch {
            repository.getPopularMovies().collect {
                _movieResponse.postValue(it)
            }
        }
    }


}