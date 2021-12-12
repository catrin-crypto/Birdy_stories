package com.example.birdystories.data.api

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

object WikiApiErrorInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return try {
            chain.proceed(chain.request())
        } catch (error: Throwable) {
            throw when (error) {
                is IOException -> RuntimeException("Нет соединения с сетью")
                else -> error
            }
        }
    }

}