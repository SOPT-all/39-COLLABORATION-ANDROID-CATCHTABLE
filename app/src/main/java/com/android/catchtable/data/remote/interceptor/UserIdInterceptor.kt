package com.android.catchtable.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class UserIdInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request().newBuilder()
                .header(HEADER_USER_ID, USER_ID.toString())
                .build()
        )

    private companion object {
        const val HEADER_USER_ID = "X-User-Id"
        const val USER_ID = 1L
    }
}
