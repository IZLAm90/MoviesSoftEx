package com.izlam.taskhamserv.localData

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Covert {
    @TypeConverter
    fun convertGeners(id :List<Int>):String{
        return Gson().toJson(id)
    }
    @TypeConverter
    fun convertGsonToGen(id :String): List<Int> ? {
        val listType = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(id,listType)
    }

}