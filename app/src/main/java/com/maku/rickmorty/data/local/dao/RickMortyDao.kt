package com.maku.rickmorty.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maku.rickmorty.data.local.entities.AllCharactersResponse
import com.maku.rickmorty.data.local.entities.DATA_ID

@Dao
interface RickMortyDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun upsert(allcharacters: AllCharactersResponse) //update or insert at the same time

        @Query("select * from rick_morty_details where id = $DATA_ID")
        fun getRickAndMortyData(): LiveData<AllCharactersResponse>

    }
