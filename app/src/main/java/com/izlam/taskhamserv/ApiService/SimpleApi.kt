package com.izlam.taskhamserv.ApiService

import com.izlam.taskhamserv.utils.Constant
import com.izlam.taskhamserv.Models.TopRateMoviesModel
import retrofit2.http.GET
import retrofit2.http.Query


interface SimpleApi {

//    @GET("player_api.php")
//    suspend fun getCategory(@Query("username" ) username:String="hmaser", @Query("password") password:String="hmaserv1987", @Query("action") action:String="get_live_categories"):Deferred<ArrayList<ModelCategory>>
//
//    @GET("player_api.php")
//    suspend fun getLiveStream(@Query("username" ) username:String="hmaser", @Query("password") password:String="hmaserv1987", @Query("action") action:String="get_live_streams"): Deferred<ArrayList<live_streamsModel>>
//    @Header("",)
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("api_key") api_key:String= Constant.API_Key,@Query("page") page:Int =1):TopRateMoviesModel

 }