package com.izlam.taskhamserv.Models

import com.google.gson.annotations.SerializedName

data class RecitersResponse(

	@field:SerializedName("data")
	val data: List<Reciter?>? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("meta")
	val meta: Meta? = null
)
data class Meta(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("last_page")
	val lastPage: Int? = null,

	@field:SerializedName("from")
	val from: Int? = null,

	@field:SerializedName("links")
	val links: List<LinksItem?>? = null,

	@field:SerializedName("to")
	val to: Int? = null,

	@field:SerializedName("current_page")
	val currentPage: Int? = null
)
data class LinksItem(

	@field:SerializedName("active")
	val active: Boolean? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("url")
	val url: Any? = null
)
data class Reciter(

	@field:SerializedName("image") val image: String? = null,

	@field:SerializedName("letter") val letter: String? = null,

	@field:SerializedName("name") val name: String? = null,

	@field:SerializedName("description") val description: String? = null,

	@field:SerializedName("id") val id: Int? = null,
	@field:SerializedName("moshafs") val moshafs: List<MoshafItem?>? = null,

	@field:SerializedName("moshaf") val moshaf: List<MoshafItem?>? = null
)


data class MoshafItem(

	@field:SerializedName("server")
	val server: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("surah_list")
	val surahList: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("surah_total")
	val surahTotal: Int? = null
)

