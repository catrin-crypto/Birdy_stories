package com.example.birdystories.presentation.navigation

import android.net.Uri
import com.github.terrakok.cicerone.Router

class CustomRouter : Router() {

    interface Command {
        fun execute(navigator: CustomNavigator)
    }

//    fun openDeepLink(deepLink: Uri?) {
//        executeCommands(OpenDeepLink(deepLink))
//    }

}