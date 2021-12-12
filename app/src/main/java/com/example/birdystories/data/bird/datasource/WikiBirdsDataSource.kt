package com.example.birdystories.data.bird.datasource

import com.example.birdystories.data.api.WikiBird
import io.reactivex.rxjava3.core.Observable

interface WikiBirdsDataSource {
    fun getWikiBirds(): Observable<List<WikiBird>>

}