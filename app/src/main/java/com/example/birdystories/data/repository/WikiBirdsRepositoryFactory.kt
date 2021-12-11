package com.example.birdystories.data.repository

import com.example.birdystories.data.api.WikiApiFactory
import com.example.birdystories.data.bird.datasource.WikiBirdsCacheDataSourceImpl
import com.example.birdystories.data.bird.datasource.WikiBirdsDataSourceImpl
import com.example.birdystories.data.storage.WikiBirdsDbFactory

object WikiBirdsRepositoryFactory {

    private val wikiBirdsRepository: WikiBirdsRepository by lazy(LazyThreadSafetyMode.NONE) {
        WikiBirdsRepositoryImpl(
            WikiBirdsDataSourceImpl(
                WikiApiFactory.create()
            ),
            WikiBirdsCacheDataSourceImpl(
                WikiBirdsDbFactory.create()
            )
         )
    }

    fun create(): WikiBirdsRepository = wikiBirdsRepository

}