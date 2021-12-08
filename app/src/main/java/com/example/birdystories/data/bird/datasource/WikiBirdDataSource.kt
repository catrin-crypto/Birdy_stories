package com.example.birdystories.data.bird.datasource

import com.example.birdystories.data.api.WikiBird
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

interface WikiBirdDataSource {
    fun getWikiBirds(): Single<List<WikiBird>>

}