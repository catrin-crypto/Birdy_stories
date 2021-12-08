package com.example.birdystories.data.bird.datasource

import com.example.birdystories.data.api.WikiBird
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface WikiBirdCacheDataSource {
    fun getAllBirds(): Observable<List<WikiBird>>
    fun getWikiBirdById(id: Int): Observable<WikiBird>
    fun retain(wikiBirds: List<WikiBird>): Observable<List<WikiBird>>

}