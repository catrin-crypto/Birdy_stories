package com.example.birdystories.data.repository

import com.example.birdystories.data.api.WikiBird
import io.reactivex.rxjava3.core.Observable

interface WikiBirdsRepository {
    fun getWikiBirds(): Observable<List<WikiBird>>

    fun getWikiBird(title: String): Observable<WikiBird>

}