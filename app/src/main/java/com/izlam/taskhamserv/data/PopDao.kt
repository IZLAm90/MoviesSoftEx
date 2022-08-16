package com.izlam.taskhamserv.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.izlam.taskhamserv.Models.Results
import com.izlam.taskhamserv.Models.TopRateMoviesModel

@Dao
interface PopDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insetPopular(topRateMoviesModel: TopRateMoviesModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResultMov(results: Results)
}