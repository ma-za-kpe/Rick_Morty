package com.maku.rickmorty.data.remote.networksource

import androidx.lifecycle.LiveData
import com.maku.rickmorty.data.local.entities.AllCharactersResponse

interface RickAndMortyDataSource {
    val downloadedfetchRickAndMortyData: LiveData<AllCharactersResponse> // Live data data type, which can be observed for change in the repository class.

    suspend fun fetchRickAndMortyData() //Asynchronous code ??? Runs separate from the main code.)
}