package com.maku.rickmorty.data.model


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("count")
    val count: Int, // 671
    @SerializedName("next")
    val next: String, // https://rickandmortyapi.com/api/character/?page=2
    @SerializedName("pages")
    val pages: Int, // 34
    @SerializedName("prev")
    val prev: Any // null
)