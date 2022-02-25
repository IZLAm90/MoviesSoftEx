package com.izlam.taskhamserv.Repositorys

import com.izlam.taskhamserv.ApiService.RetrofitInstance
import com.izlam.taskhamserv.Models.ModelCategory
import com.izlam.taskhamserv.Models.live_streamsModel
import retrofit2.Response

class Repository {

    suspend fun getCategory(action:String):Response<ArrayList<ModelCategory>>{
        return RetrofitInstance.api.getCategory(action=action)
    }

    suspend fun getLiveStram():Response<ArrayList<live_streamsModel>>{
        return RetrofitInstance.api.getLiveStream()
    }
}