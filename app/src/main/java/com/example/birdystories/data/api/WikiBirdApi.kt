package com.example.birdystories.data.api

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WikiBirdApi {
    @GET("api.php")
    fun fetchAllBirds(@Query("action") action:String = "parse",
                   @Query("format") format:String = "json",
                   @Query("page") page:String = "Список_птиц_России",
                   @Query("prop") prop:String = "links",
                   @Query("section") section:Int = 1,
                   @Query("disableeditsection") disableeditsection:Int = 1,
                   @Query("disablestylededuplication") disablestylededuplication:Int = 1,
                   @Query("disabletoc") disabletoc:Int = 1,
                   @Query("mobileformat") mobileformat:Int =1,
                   @Query("mainpage") mainpage:Int = 1,
                   @Query("utf8") utf8:Int = 1,
                   @Query("formatversion") formatversion:Int = 2
    ): Observable<WikiBirdParseResponse>

    @GET("api.php")
    fun fetchBirdsByPageNames(
        @Query("titles") titles:String,
        @Query("pithumbsize") pithumbsize:Int = 200,
        @Query("action") action:String = "query",
        @Query("format") format:String = "json",
        @Query("prop") prop:String = "extracts|pageimages",
        @Query("utf8") utf8:Int = 1,
        @Query("exsentences") exsentences:Int = 10,
        @Query("exintro") exintro:Int = 1,
        @Query("explaintext") explaintext:Int = 1,
        @Query("exsectionformat") exsectionformat:String = "plain",
        @Query("piprop") piprop:String = "thumbnail|name|original",
        @Query("pilimit") pilimit:Int = 50

    ): Observable<WikiBirdQueryResponse>

}