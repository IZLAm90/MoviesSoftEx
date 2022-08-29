package com.izlam.taskhamserv.localData

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.izlam.taskhamserv.Models.Genre
import com.izlam.taskhamserv.Models.Results

@Dao
interface Dao {     
    @Insert(onConflict = REPLACE)
    fun insertGeners(genre: ArrayList<Genre>)

    @Query("SELECT * FROM Genre")
    fun getAllGeners(): List<Genre>
    
    
    @Insert(onConflict = REPLACE)
    fun insertMoviesResult(result: List<Results>)
    
    @Query("SELECT * FROM results")
    fun getAllResults():List<Results>


    @Query("SELECT * FROM results WHERE  genre_ids in (1,18,35)")
     fun getFilterByGen():List<Results>
}