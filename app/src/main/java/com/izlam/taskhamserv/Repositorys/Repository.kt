package com.izlam.taskhamserv.Repositorys

import android.util.Log
import com.izlam.taskhamserv.ApiService.SimpleApi
import com.izlam.taskhamserv.localData.Dao
import com.izlam.taskhamserv.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class Repository @Inject constructor(private val apiService:SimpleApi,private val dao: Dao) {


    suspend fun getPopularMovies(page:Int)= flow{
        emit(NetworkResult.Loading(true))
        val responce=apiService.getTopRatedMovies(page = page)
        emit(NetworkResult.Success(responce))
        dao.insertMoviesResult(responce.results)
    }.flowOn(Dispatchers.IO)
        .catch { e->
        emit(NetworkResult.Failure(e.message ?: "unKwonError"))
    }

    suspend fun getFilterDB(id : Int) = flow{
        emit(dao.getAllResults().asFlow().filter {
            it.genre_ids[0]==id
        }.buffer())
    }.flowOn(Dispatchers.IO)




    suspend fun getMoviesCategories()= flow {
        emit(NetworkResult.Loading(true))
        val responce=apiService.getMoviesCategores()
        emit(NetworkResult.Success(responce))
        dao.insertGeners(responce.gener)
    }.flowOn(Dispatchers.IO)
        .catch { e ->
            emit(NetworkResult.Failure(e.message ?: "unKwonError"))

        }

}