package com.example.birdystories.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.birdystories.data.api.WikiBird
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface WikiBirdDao {

    @Query("SELECT * FROM wiki_birds ORDER BY title ASC")
    fun getBirds(): Observable<List<WikiBird>>

    @Query("SELECT * FROM wiki_birds WHERE title LIKE :pageTitle LIMIT 1")
    fun getBirdByPageTitle(pageTitle: String): Observable<WikiBird>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(wikiBirds: List<WikiBird>): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(wikiBird: WikiBird): Completable

}