package com.example.birdystories.di

import com.example.birdystories.data.api.ExtendedInfoRequester
import com.example.birdystories.data.api.ExtendedInfoRequesterImpl
import com.example.birdystories.data.bird.datasource.WikiBirdsCacheDataSource
import com.example.birdystories.data.bird.datasource.WikiBirdsCacheDataSourceImpl
import com.example.birdystories.data.bird.datasource.WikiBirdsDataSource
import com.example.birdystories.data.bird.datasource.WikiBirdsDataSourceImpl
import com.example.birdystories.data.repository.WikiBirdsRepository
import com.example.birdystories.data.repository.WikiBirdsRepositoryImpl
import com.example.birdystories.presentation.MainActivity
import com.example.birdystories.presentation.bird.BirdInfoFragment
import com.example.birdystories.presentation.birds.BirdsListFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [NetworkModule::class, StorageModule::class])
interface WikiBirdModule {

    @ContributesAndroidInjector
    fun bindMainFragment(): MainActivity

    @ContributesAndroidInjector
    fun bindBirdsListFragment(): BirdsListFragment

    @ContributesAndroidInjector
    fun bindBirdInfoFragment(): BirdInfoFragment

    @Binds
    fun bindWikiBirdsRepository(
        wikiBirdsRepository: WikiBirdsRepositoryImpl
    ): WikiBirdsRepository

    @Binds
    fun bindWikiBirdsDataSource(
        gitHubUserDataSource: WikiBirdsDataSourceImpl
    ): WikiBirdsDataSource

    @Binds
    fun bindWikiBirdsCacheDataSource(
        gitHubUserCacheDataSource: WikiBirdsCacheDataSourceImpl
    ): WikiBirdsCacheDataSource

    @Binds
    fun bindExtendedInfoRequester(
        extendedInfoRequester: ExtendedInfoRequesterImpl
    ): ExtendedInfoRequester

}