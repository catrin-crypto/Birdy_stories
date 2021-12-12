package com.example.birdystories.presentation

import android.os.Bundle
import com.example.birdystories.presentation.abs.AbsActivity
import com.example.birdystories.presentation.birds.BirdsScreen
import com.example.birdystories.presentation.navigation.CustomNavigator
import com.example.birdystories.presentation.navigation.CustomRouter
import com.github.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class MainActivity : AbsActivity() {
    private val navigator = CustomNavigator(activity = this, android.R.id.content)

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: CustomRouter

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            router.newRootScreen(BirdsScreen)
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}