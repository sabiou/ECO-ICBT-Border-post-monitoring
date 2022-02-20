package com.sim2g.icbt.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Farouk Sabiou on 2/20/22.
 */
class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url).build()
        //Timber.d(request.toString())
        return chain.proceed(request)
    }
}