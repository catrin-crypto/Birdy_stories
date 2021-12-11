package com.example.birdystories.data.bird.datasource

import com.example.birdystories.data.api.WikiBird
import com.example.birdystories.data.storage.WikiBirdsDB
import io.reactivex.rxjava3.core.Observable

class WikiBirdsCacheDataSourceImpl (
    private val wikiBirdsDb : WikiBirdsDB
) : WikiBirdsCacheDataSource{

    override fun retain(wikiBirds: List<WikiBird>): Observable<List<WikiBird>> =
        wikiBirdsDb
            .getWikiBirdDao()
            .retain(wikiBirds)
            .andThen(
                wikiBirdsDb
                    .getWikiBirdDao()
                    .getBirds()
            )

    override fun getAllBirds(): Observable<List<WikiBird>> =
        wikiBirdsDb.getWikiBirdDao().getBirds()

    override fun getWikiBirdByTitle(title: String): Observable<WikiBird> =
        wikiBirdsDb.getWikiBirdDao().getBirdByPageTitle(title)
}

