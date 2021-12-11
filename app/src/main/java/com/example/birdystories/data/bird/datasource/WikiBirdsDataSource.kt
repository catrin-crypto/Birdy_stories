package com.example.birdystories.data.bird.datasource

import com.example.birdystories.data.api.WikiBird
import com.example.birdystories.data.api.WikiBirdQueryResponse
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface WikiBirdsDataSource {
    fun getWikiBirds(): Observable<List<WikiBird>>

}