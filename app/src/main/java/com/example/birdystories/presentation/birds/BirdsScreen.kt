package com.example.birdystories.presentation.birds

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object BirdsScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        BirdsListFragment.newInstance()

}