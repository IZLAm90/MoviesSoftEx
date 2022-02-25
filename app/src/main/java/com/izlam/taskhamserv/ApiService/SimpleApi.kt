package com.izlam.taskhamserv.ApiService

import com.izlam.taskhamserv.Models.ModelCategory
import com.izlam.taskhamserv.Models.live_streamsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface SimpleApi {

    @GET("player_api.php")
    suspend fun getCategory(@Query("username" ) username:String="hmaser", @Query("password") password:String="hmaserv1987", @Query("action") action:String="get_live_categories"):Response<ArrayList<ModelCategory>>

    @GET("player_api.php")
    suspend fun getLiveStream(@Query("username" ) username:String="hmaser", @Query("password") password:String="hmaserv1987", @Query("action") action:String="get_live_streams"):Response<ArrayList<live_streamsModel>>

 }