package com.example.birdystories.presentation.bird

import com.example.birdystories.data.api.WikiBird
import com.example.birdystories.presentation.ScreenView
import moxy.viewstate.strategy.alias.SingleState

interface BirdView : ScreenView {
    @SingleState
    fun showBird(bird: WikiBird)
}