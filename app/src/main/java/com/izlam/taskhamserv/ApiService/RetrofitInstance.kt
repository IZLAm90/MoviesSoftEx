package com.izlam.taskhamserv.ApiService

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    var BASE_URL:String="http://magic-tv.live:2095/"

    private val clint = OkHttpClient.Builder().apply {
        addInterceptor(MyInterceptor())
    }.build()
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(clint)
            .build()
    }
    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}