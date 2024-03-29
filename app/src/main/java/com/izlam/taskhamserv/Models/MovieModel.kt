package com.izlam.taskhamserv.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

data class MovieModel(
    val adult: Boolean,

    @Json(name = "backdrop_path")
    val backdropPath: String ?=null,

    @Json(name = "belongs_to_collection")
    val belongsToCollection: Any? = null,

    val budget: Long,
    val genres: List<Genre>,
    val homepage: String,
    val id: Long,

    @Json(name = "imdb_id")
    val imdbID: String,

    @Json(name = "original_language")
    val originalLanguage: String,

    @Json(name = "original_title")
    val originalTitle: String,

    val overview: String,
    val popularity: Double,

    @Json(name = "poster_path")
    val posterPath: String ? = null,

    @Json(name = "production_companies")
    val productionCompanies: List<ProductionCompany>,

    @Json(name = "production_countries")
    val productionCountries: List<ProductionCountry>,

    @Json(name = "release_date")
    val releaseDate: String,

    val revenue: Long,
    val runtime: Long,

    @Json(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,

    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,

    @Json(name = "vote_average")
    val voteAverage: Double,

    @Json(name = "vote_count")
    val voteCount: Long
)
@Entity
data class Genre(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String
)

data class ProductionCompany(
    val id: Long,

    @Json(name = "logo_path")
    val logoPath: String? = null,

    val name: String,

    @Json(name = "origin_country")
    val originCountry: String
)

data class ProductionCountry(
    @Json(name = "iso_3166_1")
    val iso3166_1: String,

    val name: String
)

data class SpokenLanguage(
    @Json(name = "english_name")
    val englishName: String,

    @Json(name = "iso_639_1")
    val iso639_1: String,

    val name: String
)