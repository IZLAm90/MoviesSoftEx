package com.izlam.taskhamserv.localData

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.izlam.taskhamserv.Models.Genre
import com.izlam.taskhamserv.Models.Results

@Database(entities = [Genre::class, Results::class], version = 1)
@TypeConverters(Covert::class)
abstract class AppDB :RoomDatabase() {
    abstract fun appDao():Dao
}