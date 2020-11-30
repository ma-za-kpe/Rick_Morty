package com.maku.rickmorty.data.local.entities


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.maku.rickmorty.data.model.Info
import com.maku.rickmorty.data.model.Result

const val DATA_ID = 0
@Entity(tableName = "rick_morty_details")
data class AllCharactersResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Result>
){
    @PrimaryKey(autoGenerate = false)
    var id: Int = DATA_ID
}