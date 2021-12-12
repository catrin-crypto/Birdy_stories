package com.example.birdystories.presentation.bird

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory


@AssistedFactory
interface WikiBirdPresenterAssistedFactory {

    fun create(@Assisted("title") birdTitle: String): BirdPresenter

}