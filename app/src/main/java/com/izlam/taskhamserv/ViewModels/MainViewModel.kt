package com.izlam.taskhamserv.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.izlam.taskhamserv.ApiService.SimpleApi
import com.izlam.taskhamserv.ApiService.di.NetworkModule
import com.izlam.taskhamserv.Models.GenresModel
import com.izlam.taskhamserv.Models.RecitersResponse
import com.izlam.taskhamserv.Models.Results
import com.izlam.taskhamserv.Models.TopRateMoviesModel
import com.izlam.taskhamserv.utils.NetworkResult
import com.izlam.taskhamserv.Repositorys.Repository
import com.izlam.taskhamserv.localData.Dao
import com.izlam.taskhamserv.utils.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import retrofit2.Retrofit


import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor (private val apiService:SimpleApi,private val repository: Repository, private val dao: Dao): ViewModel() {

    private var _movieResponse = MutableLiveData<NetworkResult<TopRateMoviesModel>>()
    val movieResponse: LiveData<NetworkResult<TopRateMoviesModel>> = _movieResponse

    init {
        fetchAllMovies(1)
        getMoviesCategoris()
    }

    fun getReciter() :Flow<PagingData<RecitersResponse>>{
        return  Pager(PagingConfig(pageSize = 15)) {
            DataSource(apiService)
        }.flow
    }
    fun fetchAllMovies(page : Int) {
        viewModelScope.launch {
            repository.getPopularMovies(page).collect {
                withContext(Dispatchers.IO){
                    delay(3000)
                    Log.d("islam", "fetchAllMovies  DB: ${  dao.getAllResults()}")
                }
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


    private val _filterList =MutableLiveData<Results>()
    val filterList :LiveData<Results> =_filterList

    fun getFilter( id : Int){
        viewModelScope.launch {
            repository.getFilterDB(id).collect{
                it.buffer().collect{
                    Log.d("islam", "getFilter: ${it}")
                    _filterList.postValue(it)
                }
            }
        }
    }


}