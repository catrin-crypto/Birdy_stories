package com.example.birdystories.data.bird.datasource

import com.example.birdystories.data.api.WikiBird
import com.example.birdystories.data.api.WikiBirdApi
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.toObservable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class WikiBirdsDataSourceImpl
@Inject constructor(
    private val wikiBirdApi: WikiBirdApi
) : WikiBirdsDataSource {

    override fun getWikiBirds(): Observable<List<WikiBird>> =
        wikiBirdApi
            .fetchAllBirds()
            .observeOn(Schedulers.io())
            .flatMap { response ->
                Observable.fromArray(response.parse.links)
            }
            .filter { (wikiBirdName) -> wikiBirdName.exists }
            .flatMapIterable { list -> list }
            .map { wikiBirdName -> wikiBirdName.title }
            .filter { s -> s.firstOrNull { it in 'А'..'Я' || it in 'а'..'я' } != null }
            .filter { s -> !s.contains(':')}
            .filter { s -> !s.startsWith("Список") }
            .toList()
            .toObservable()
            .flatMap { birdsNames ->
                birdsNames.chunked(19).toObservable()
            }
            .concatMap({ pagesNames ->
                wikiBirdApi.fetchBirdsByPageNames(
                    pagesNames.joinToString("|")
                )
            }, 100, Schedulers.io())
            .flatMap { response ->
                Observable.fromArray(
                    response.query
                        .pages.values.toList()
                )
            }
            .flatMapIterable { list -> list }
            .filter{bird-> bird.extract!=null && bird.extract != ""}
            .toList()
            .toObservable()
}
