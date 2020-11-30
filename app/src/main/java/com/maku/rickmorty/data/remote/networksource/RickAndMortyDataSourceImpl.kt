package com.maku.rickmorty.data.remote.networksource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.maku.rickmorty.data.local.entities.AllCharactersResponse
import com.maku.rickmorty.data.remote.service.RickAndMortyService
import timber.log.Timber
import java.io.IOException

class RickAndMortyDataSourceImpl(val rickAndMortyService: RickAndMortyService) : RickAndMortyDataSource {

    private val _downloadedfetchRickAndMortyData = MutableLiveData<AllCharactersResponse>() // can be changed, you now do stuff to it
    override val downloadedfetchRickAndMortyData: LiveData<AllCharactersResponse>
        get() = _downloadedfetchRickAndMortyData

    override suspend fun fetchRickAndMortyData() {

        try {
            val fetchedRickAndMortyData = rickAndMortyService
                .getPhotos()
                ?.await()
            _downloadedfetchRickAndMortyData.postValue(fetchedRickAndMortyData)
            Timber.d("data %s", fetchedRickAndMortyData)
        } catch (exception: IOException){
            Timber.d("exception %s", exception.message)
        }
    }
}