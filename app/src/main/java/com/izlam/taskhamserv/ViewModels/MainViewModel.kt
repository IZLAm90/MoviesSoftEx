package com.izlam.taskhamserv.ViewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.izlam.taskhamserv.Models.ModelCategory
import com.izlam.taskhamserv.Models.live_streamsModel
import com.izlam.taskhamserv.Repositorys.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var myResponse: MutableLiveData<Response<ArrayList<ModelCategory>>> = MutableLiveData()
    var responcelive:MutableLiveData<Response<ArrayList<live_streamsModel>>> =MutableLiveData()

    fun getPost(action :String){
        viewModelScope.launch {
            val response = repository.getCategory(action)
            myResponse.value = response
            Log.d("response1",response.message().toString())

        }
    }

    fun get(){
        viewModelScope.launch {
            val response=repository.getLiveStram()
            responcelive.value=response
            Log.d("response2",response.message().toString())
        }

    }





}