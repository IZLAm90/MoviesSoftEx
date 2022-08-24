package com.izlam.taskhamserv.ApiService

import com.izlam.taskhamserv.Models.GenresModel
import com.izlam.taskhamserv.Models.MovieModel
import com.izlam.taskhamserv.utils.Constant
import com.izlam.taskhamserv.Models.TopRateMoviesModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query


interface SimpleApi {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") api_key: String = Constant.API_Key,
        @Query("page") page: Int = 1
    ): TopRateMoviesModel

    @GET("movie/{movie_id}")
    suspend fun getMovies(
        @Path("movie_id") id: Int,
        @Query("api_key") api_key: String = Constant.API_Key,
        @Query("language") language: String = "en-US"
    ): MovieModel

    @GET("/3/movie/{movie_id}/recommendations")
    suspend fun getRecoMovies(
        @Path("movie_id") id: Int,
        @Query("api_key") api_key: String = Constant.API_Key,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): TopRateMoviesModel


    @GET("/3/genre/movie/list")
    suspend fun getMoviesCategores(
        @Header("api_key") api_key: String = Constant.API_Key,
        @Query("language") language: String = "ut"
    ): GenresModel



}