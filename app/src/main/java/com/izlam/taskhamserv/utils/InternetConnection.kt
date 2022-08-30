package com.izlam.taskhamserv.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET

class InternetConnection {
    fun hasInternet(context : Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork

        val capabilities = connectivityManager.getNetworkCapabilities(network)
        var hasInternet = false
        capabilities?.let {
            hasInternet = it.hasCapability(NET_CAPABILITY_INTERNET)
        }
        return hasInternet

    }
}