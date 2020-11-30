package com.maku.rickmorty.data.model


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name")
    val name: String, // Earth (Replacement Dimension)
    @SerializedName("url")
    val url: String // https://rickandmortyapi.com/api/location/20
)