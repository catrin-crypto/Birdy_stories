package com.example.birdystories.presentation.birds

import com.example.birdystories.data.api.WikiBird
import com.example.birdystories.presentation.ScreenView
import moxy.viewstate.strategy.alias.SingleState

interface BirdsView : ScreenView {

    @SingleState
    fun showBirds(birds: List<WikiBird>)

}