package com.maku.rickmorty.data.model


import com.google.gson.annotations.SerializedName

data class Origin(
    @SerializedName("name")
    val name: String, // Earth (C-137)
    @SerializedName("url")
    val url: String // https://rickandmortyapi.com/api/location/1
)