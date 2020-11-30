package com.maku.rickmorty.data.remote.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.maku.rickmorty.BuildConfig
import com.maku.rickmorty.data.local.entities.AllCharactersResponse
import com.maku.rickmorty.data.remote.internetstatus.ConnectivityInterceptor
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// base url : https://rickandmortyapi.com/api/character/

interface RickAndMortyService {
    @GET("api/character")
    fun getPhotos(): Deferred<AllCharactersResponse>?

    companion object{
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): RickAndMortyService {

            val okHttpClient = OkHttpClient
                .Builder()
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RickAndMortyService::class.java)
        }

    }


}