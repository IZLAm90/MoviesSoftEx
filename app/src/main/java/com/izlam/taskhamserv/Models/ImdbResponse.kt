package com.izlam.taskhamserv.Models

import com.squareup.moshi.Json

data class ImdbResponse(
    @field:Json(name = "status")
    var status: Boolean,
    @field:Json(name = "video_url")
    var youtubeUrl: String,
    @field:Json(name = "videofullurl")
    var videoUrl: String?,
    @field:Json(name = "video_id")
    var id: String,
    @field:Json(name = "data")
    var data: ImdbData,
)

data class ImdbData(
    @field:Json(name = "title")
    var title: String,
    @field:Json(name = "fullTitle")
    var fullTitle: String,
    @field:Json(name = "type")
    var type: String,
    @field:Json(name = "year")
    var year: String,
    @field:Json(name = "image")
    var image: String,
    @field:Json(name = "releaseDate")
    var releaseDate: String,
    @field:Json(name = "runtimeStr")
    var duration: String,
    @field:Json(name = "plot")
    var description: String?,
    @field:Json(name = "awards")
    var awards: String?,
    @field:Json(name = "directors")
    var directors: String,
    @field:Json(name = "writers")
    var writers: String,
    @field:Json(name = "genres")
    var genres: String,
    @field:Json(name = "companies")
    var companies: String,
    @field:Json(name = "countries")
    var countries: String,
    @field:Json(name = "languages")
    var languages: String,
    @field:Json(name = "imDbRating")
    var rating: String,
    @field:Json(name = "actorList")
    var actors: List<Actor>?,
    @field:Json(name = "images")
    var images: Images?,
)
data class Actor(
    @field:Json(name = "id")
    var id: String,
    @field:Json(name = "image")
    var image: String,
    @field:Json(name = "name")
    var name: String,
    @field:Json(name = "asCharacter")
    var asCharacter: String,
)

data class Images(
    @field:Json(name = "items")
    var items: List<Items>,
)

data class Items(
    @field:Json(name = "image")
    var image: String,
)