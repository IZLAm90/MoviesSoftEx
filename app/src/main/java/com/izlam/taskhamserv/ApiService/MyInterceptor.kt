package com.izlam.taskhamserv.ApiService

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        Log.i("API_URL","${chain.request().url}")

        return chain.proceed(chain.request())
    }
}