package com.example.birdystories

import com.example.birdystories.di.DaggerBirdyStoriesComponent
import com.example.birdystories.presentation.navigation.CustomRouter
import com.example.birdystories.schedulers.SchedulersFactory
import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BirdyStories : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerBirdyStoriesComponent
            .builder()
            .withContext(applicationContext)
            .withSchedulers(SchedulersFactory.create())
            .apply {
                val cicerone = Cicerone.create(CustomRouter())
                withRouter(cicerone.router)
                withNavigatorHolder(cicerone.getNavigatorHolder())
            }
            .build()
}
