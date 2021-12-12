package com.example.birdystories.presentation.birds

import dagger.assisted.AssistedFactory


@AssistedFactory
interface BirdsListPresenterAssistedFactory {

    fun create(): BirdsListPresenter

}