package com.maku.rickmorty.data.remote.internetstatus

import android.content.Context
import com.maku.rickmorty.internal.NoConnectivityException
import com.maku.rickmorty.utils.NetworkUtils
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

class ConnectivityInterceptorImpl(context: Context) : ConnectivityInterceptor {
    private val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!NetworkUtils.getNetworkLiveData(appContext).value!!){
            Timber.d("valuee %s", NetworkUtils.getNetworkLiveData(appContext).value!!)
            throw NoConnectivityException()
        }
        return chain.proceed(chain.request())
    }
}