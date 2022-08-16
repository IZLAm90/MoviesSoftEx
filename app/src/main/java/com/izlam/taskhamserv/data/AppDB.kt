package com.izlam.taskhamserv.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bumptech.glide.load.model.ByteArrayLoader
import com.izlam.taskhamserv.Models.Results
import com.izlam.taskhamserv.Models.TopRateMoviesModel

@Database(entities = [TopRateMoviesModel::class, Results::class], version = 0, exportSchema = true)
abstract class AppDB : RoomDatabase() {
    abstract fun channelDao(): PopDao
}