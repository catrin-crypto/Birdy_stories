package com.example.birdystories.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.birdystories.data.api.OriginalConverter
import com.example.birdystories.data.api.ThumbnailConverter
import com.example.birdystories.data.api.WikiBird

@Database(exportSchema = false, entities = [WikiBird::class], version = 1)
@TypeConverters(ThumbnailConverter::class,OriginalConverter::class)
abstract class WikiBirdsDB : RoomDatabase() {
    abstract fun getWikiBirdDao(): WikiBirdDao
}