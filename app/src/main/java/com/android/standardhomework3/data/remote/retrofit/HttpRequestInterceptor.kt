package com.android.standardhomework3.data.remote.retrofit

import okhttp3.Interceptor
import okhttp3.Response

internal class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request()
                .newBuilder()
                .run {
                    this
                }
                .build()
        )
    }
}