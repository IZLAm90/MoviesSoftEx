package com.izlam.taskhamserv.ApiService.di

import android.util.Log
import com.izlam.taskhamserv.ApiService.SimpleApi
import com.izlam.taskhamserv.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    val apiServiceHeader = Interceptor { chain ->
        val request = chain.request().newBuilder().addHeader("Authorization", "Bearer " + Constant.Bearer_Token)
        Log.d("islam", "provideLoggingInterceptor: ${chain.request()} ")
        chain.proceed(request.build())
    }
    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(500, TimeUnit.SECONDS)
            .callTimeout(500, TimeUnit.SECONDS)
            .connectTimeout(500, TimeUnit.SECONDS)
            .writeTimeout(500, TimeUnit.SECONDS)
            .addInterceptor(apiServiceHeader)
            .build()
    }

    @Singleton
    @Provides
    @Named("loggingInterceptor")
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.HEADERS
            Log.d("islam", "provideLoggingInterceptor: ${this.level} ")
        }
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideApiClient(retrofit: Retrofit): SimpleApi {
        return retrofit.create(SimpleApi::class.java)
    }
}