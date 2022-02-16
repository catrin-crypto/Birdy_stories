package com.example.birdystories

import com.example.birdystories.data.repository.WikiBirdsRepository
import com.example.birdystories.presentation.birds.BirdsListPresenter
import com.example.birdystories.presentation.navigation.CustomRouter
import com.example.birdystories.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class BirdsListPresenterTest {
    private lateinit var presenter: BirdsListPresenter

    @Mock
    private lateinit var router: CustomRouter

    @Mock
    private lateinit var schedulers: Schedulers

    @Mock
    private lateinit var repository: WikiBirdsRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = BirdsListPresenter(repository, router, schedulers)
    }

    @Test
    fun onFirstViewAttachTest() {
        repository.getWikiBirds()
        Mockito.verify(repository, Mockito.times(1)).getWikiBirds()
    }
}