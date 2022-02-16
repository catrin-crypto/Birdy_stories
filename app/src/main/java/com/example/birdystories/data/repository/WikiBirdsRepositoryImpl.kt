package com.example.birdystories.data.repository

import com.example.birdystories.data.api.WikiBird
import com.example.birdystories.data.bird.datasource.WikiBirdsCacheDataSource
import com.example.birdystories.data.bird.datasource.WikiBirdsDataSource
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class WikiBirdsRepositoryImpl
@Inject constructor(
    private val wikiBirdsDataSource: WikiBirdsDataSource,
    private val wikiBirdsCacheDataSource: WikiBirdsCacheDataSource,
) : WikiBirdsRepository {
    override fun getWikiBirds(): Observable<List<WikiBird>> =
        Observable.mergeDelayError(
            wikiBirdsCacheDataSource
                .getAllBirds(),
            wikiBirdsDataSource
                .getWikiBirds()
                .flatMap { birds ->
                    wikiBirdsCacheDataSource.retain(birds)
                }

        )


    override fun getWikiBird(title: String): Observable<WikiBird> =
        wikiBirdsCacheDataSource
            .getWikiBirdByTitle(title)
}

