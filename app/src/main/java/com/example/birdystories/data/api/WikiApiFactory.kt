package com.example.birdystories.data.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object WikiApiFactory {
    private val gson: Gson =
        GsonBuilder()
            .setPrettyPrinting()
            .create()

    private val wikiBirdApi: WikiBirdApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://ru.wikipedia.org/w/api.php")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(WikiApiErrorInterceptor)
                    .build()
            )
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createSynchronous())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(WikiBirdApi::class.java)
    }

    fun create(): WikiBirdApi = wikiBirdApi
}