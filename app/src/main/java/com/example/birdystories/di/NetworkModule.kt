package com.example.birdystories.di

import com.example.birdystories.data.api.WikiApiErrorInterceptor
import com.example.birdystories.data.api.WikiBirdApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideGson(): Gson =
        GsonBuilder()
            .setPrettyPrinting()
            .create()

    @Reusable
    @Provides
    fun provideWikiBirdApi(gson: Gson): WikiBirdApi =
        Retrofit.Builder()
            .baseUrl("https://ru.wikipedia.org/w/")
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