package com.izlam.taskhamserv.utils

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.izlam.taskhamserv.ApiService.SimpleApi
import com.izlam.taskhamserv.Models.RecitersResponse

class DataSource(private val api: SimpleApi) : PagingSource<Int, RecitersResponse>() {
    override fun getRefreshKey(state: PagingState<Int, RecitersResponse>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RecitersResponse> {
        return try {
            val currentPage = params.key ?: 1
            val response = api.getBroadCastingReciters(currentPage)
            Log.d("islam", "load : ${response} ")
            val data = response.body()?.data as List<RecitersResponse>
            Log.d("islam", "load : ${data} ")
            val nextPage = if (data?.isEmpty() == true) {
                null // If data is empty, there are no more pages
            } else {
                currentPage + 1
            }
            LoadResult.Page(
                data = data,
                prevKey = null,
                nextKey = nextPage
            )
        } catch (ex: java.lang.Exception) {
            LoadResult.Error(ex)
        }
    }
}