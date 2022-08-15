package com.izlam.taskhamserv.Models

import com.google.gson.annotations.SerializedName

data class TopRateMoviesModel(
@SerializedName("page") var page:Int=0,
@SerializedName("results") var results : List<Results>,
@SerializedName("total_pages") var totalPages: Int=0,
@SerializedName("total_results") var totalResults : Int?= null
)

