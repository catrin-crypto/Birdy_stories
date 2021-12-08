package com.example.birdystories.presentation.bird

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class BirdScreen(private val birdId: String): FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        BirdInfoFragment.newInstance()
}