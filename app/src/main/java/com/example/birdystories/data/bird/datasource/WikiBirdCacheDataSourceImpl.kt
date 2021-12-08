package com.example.birdystories.data.bird.datasource

import com.example.birdystories.data.api.WikiBird
import com.example.birdystories.data.api.WikiBirdName
import com.example.birdystories.data.storage.WikiBirdsDB
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class WikiBirdCacheDataSourceImpl (
    private val wikiBirdsDb : WikiBirdsDB
) : WikiBirdCacheDataSource{

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

    override fun getWikiBirdById(id: Int): Observable<WikiBird> =
        wikiBirdsDb.getWikiBirdDao().getBirdByPageId(id)
}

