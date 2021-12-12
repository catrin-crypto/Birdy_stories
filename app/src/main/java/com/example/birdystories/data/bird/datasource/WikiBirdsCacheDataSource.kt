package com.example.birdystories.data.bird.datasource

import com.example.birdystories.data.api.WikiBird
import io.reactivex.rxjava3.core.Observable

interface WikiBirdsCacheDataSource {
    fun getAllBirds(): Observable<List<WikiBird>>
    fun getWikiBirdByTitle(title: String): Observable<WikiBird>
    fun retain(wikiBirds: List<WikiBird>): Observable<List<WikiBird>>

}