package com.example.birdystories.data.bird.datasource

import com.example.birdystories.data.api.WikiBird
import com.example.birdystories.data.api.WikiBirdApi
import io.reactivex.rxjava3.core.Single
import java.lang.StringBuilder
import java.util.concurrent.TimeUnit

class WikiBirdsDataSourceImpl(
private val wikiBirdApi : WikiBirdApi
) : WikiBirdDataSource{

    override fun getWikiBirds(): Single<List<WikiBird>> {
        wikiBirdApi
            .fetchAllBirds()

//TODO return, flatMap
                }
            }



