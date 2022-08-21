package com.izlam.taskhamserv.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
//@Entity(tableName = "TopRateMoviesModel")
data class TopRateMoviesModel(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("page")
    var page: Int = 0,
    @SerializedName("results")
    var results: List<Results>,
    @SerializedName("total_pages") var totalPages: Int = 0,
    @SerializedName("total_results") var totalResults: Int? = null
)

