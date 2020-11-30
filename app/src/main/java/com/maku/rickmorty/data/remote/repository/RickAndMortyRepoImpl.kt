package com.maku.rickmorty.data.remote.repository

import androidx.lifecycle.LiveData
import com.maku.rickmorty.data.local.dao.RickMortyDao
import com.maku.rickmorty.data.local.entities.AllCharactersResponse
import com.maku.rickmorty.data.remote.networksource.RickAndMortyDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class RickAndMortyRepoImpl(val rickAndMortyDataSource: RickAndMortyDataSource, val dao: RickMortyDao) : RickAndMortyRepo {

    init {
        //observe forever because repos do not have a lifecycle
        rickAndMortyDataSource.downloadedfetchRickAndMortyData.observeForever{data ->
            //persist the weather data in room (CACHING)
            persistFetchedData(data)
        }
    }

    private fun persistFetchedData(data: AllCharactersResponse) {
        Timber.d("Persisting data to rooom")
        //Global scope doesnt return anything, and lifecycle changes dont affect it
        GlobalScope.launch(Dispatchers.IO) {
            dao.upsert(data)
        }

    }

    override suspend fun getRickAndMortyData(): LiveData<AllCharactersResponse> {
        initRMData()
        //withcontext returns something
        return withContext(Dispatchers.IO) {
            return@withContext dao.getRickAndMortyData()
        }
    }

    // network call which will initiate the first cashing of data inside the database
    private suspend fun initRMData() {
        fetchData()
    }

    //
    private suspend fun fetchData() {
        rickAndMortyDataSource.fetchRickAndMortyData()
    }
}