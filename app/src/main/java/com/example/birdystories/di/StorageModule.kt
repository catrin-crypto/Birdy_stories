package com.example.birdystories.di

import android.content.Context
import androidx.room.Room
import com.example.birdystories.data.storage.WikiBirdsDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): WikiBirdsDB =
        Room.databaseBuilder(context, WikiBirdsDB::class.java, "wikibirds.db")
            .build()

}