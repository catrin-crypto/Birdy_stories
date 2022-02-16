package com.example.birdystories

import com.example.birdystories.data.api.ExtendedInfoRequester
import com.example.birdystories.data.repository.WikiBirdsRepository
import com.example.birdystories.presentation.bird.BirdPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class BirdPresenterTest {
    private lateinit var presenter: BirdPresenter

    private val birdTitle: String = "title"

    @Mock
    private lateinit var repository: WikiBirdsRepository

    @Mock
    private lateinit var extendedInfoRequester: ExtendedInfoRequester

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = BirdPresenter(birdTitle, repository, extendedInfoRequester)
    }

    @Test
    fun onFirstViewAttachTest() {
        repository.getWikiBird("title")
        Mockito.verify(repository, Mockito.times(1)).getWikiBird(birdTitle)

    }

}