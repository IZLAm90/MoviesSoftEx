package com.izlam.taskhamserv.Repositorys

import com.izlam.taskhamserv.ApiService.SimpleApi
import com.izlam.taskhamserv.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(private val apiService:SimpleApi) {


    suspend fun getPopularMovies(page:Int)= flow{
        emit(NetworkResult.Loading(true))
        val responce=apiService.getTopRatedMovies(page = page)
        emit(NetworkResult.Success(responce))
    }.flowOn(Dispatchers.IO)
        .catch { e->
        emit(NetworkResult.Failure(e.message ?: "unKwonError"))
    }
//    suspend fun getCategory(action:String):Deferred<ArrayList<ModelCategory>>{
//        return RetrofitInstance.api.getCategory(action=action)
//    }
//
//    suspend fun getLiveStram():Deferred<ArrayList<live_streamsModel>>{
//        return RetrofitInstance.api.getLiveStream()
//    }
}