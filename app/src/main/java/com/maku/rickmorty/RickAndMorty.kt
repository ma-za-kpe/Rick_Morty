package com.maku.rickmorty

import android.app.Application
import timber.log.Timber

class RickAndMorty : Application() {
    override fun onCreate() {
        super.onCreate()
        //timber
        Timber.plant(Timber.DebugTree())
    }
}