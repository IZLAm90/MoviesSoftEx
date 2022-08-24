package com.izlam.taskhamserv.Models

import com.google.gson.annotations.SerializedName

data class GenresModel(
    @SerializedName("genres")
    var gener :ArrayList<Genre>
    )



