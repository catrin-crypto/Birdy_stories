package com.example.birdystories.data.storage

import androidx.room.Room
import com.example.birdystories.BirdyStories.ContextHolder.context

object WikiBirdsDbFactory {

    private val database: WikiBirdsDB by lazy {
        Room.databaseBuilder(context, WikiBirdsDB::class.java, "wikibirds.db")
            .build()
    }

    fun create(): WikiBirdsDB = database
}
