package com.example.birdystories.di

import android.content.Context
import com.example.birdystories.BirdyStories
import com.example.birdystories.presentation.navigation.CustomRouter
import com.example.birdystories.schedulers.Schedulers
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, WikiBirdModule::class])
interface BirdyStoriesComponent : AndroidInjector<BirdyStories> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        @BindsInstance
        fun withRouter(router: CustomRouter): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        fun build(): BirdyStoriesComponent

    }

}