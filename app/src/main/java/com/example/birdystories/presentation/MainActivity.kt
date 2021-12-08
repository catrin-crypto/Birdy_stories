package com.example.birdystories.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.birdystories.BirdyStories.Navigation.navigatorHolder
import com.example.birdystories.BirdyStories.Navigation.router
import com.example.birdystories.R
import com.example.birdystories.presentation.birds.BirdsScreen
import com.example.birdystories.presentation.navigation.CustomNavigator
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity() {
    private val navigator = CustomNavigator(activity = this, android.R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

//    override fun onNewIntent(intent: Intent?) {
//        super.onNewIntent(intent)
//        router.openDeepLink(intent?.data)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            router.newRootScreen(BirdsScreen)
           // router.openDeepLink(intent?.data)
        }
            //  setContentView(R.layout.activity_main)
    }
    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}