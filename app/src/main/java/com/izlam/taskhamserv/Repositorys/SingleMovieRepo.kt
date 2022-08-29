package com.izlam.taskhamserv.Repositorys

import androidx.room.Dao
import com.izlam.taskhamserv.ApiService.SimpleApi
import com.izlam.taskhamserv.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SingleMovieRepo @Inject constructor(private val api: SimpleApi) {

    suspend fun getMovie(id : Int) = flow{
        emit(NetworkResult.Loading(true))
        val responce=api.getMovies(id = id)
        emit(NetworkResult.Success(responce))
    }.flowOn(Dispatchers.IO)
        .catch { e ->
        emit(NetworkResult.Failure(e.message ?:"unkown Error"))
        }

    suspend fun getRecoMovie(id: Int)= flow {
        emit(NetworkResult.Loading(true))
        val responce=api.getRecoMovies(id = id)
        emit(NetworkResult.Success(responce))
    }.flowOn(Dispatchers.IO)
        .catch { e ->
            emit(NetworkResult.Failure(e.message ?:"unkown Error"))
        }
}