package com.maku.rickmorty.data.remote.repository

import androidx.lifecycle.LiveData
import com.maku.rickmorty.data.local.entities.AllCharactersResponse

interface RickAndMortyRepo {
    // suspend enables us to call the function from a coroutine
    suspend fun getRickAndMortyData(): LiveData<AllCharactersResponse>
}