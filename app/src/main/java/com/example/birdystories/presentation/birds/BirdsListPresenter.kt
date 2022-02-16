package com.example.birdystories.presentation.birds


import com.example.birdystories.data.api.WikiBird
import com.example.birdystories.data.repository.WikiBirdsRepository
import com.example.birdystories.presentation.bird.BirdScreen
import com.example.birdystories.presentation.navigation.CustomRouter
import com.example.birdystories.schedulers.Schedulers
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter

class BirdsListPresenter
@AssistedInject constructor(
    private val birdsRepository: WikiBirdsRepository,
    private val router: CustomRouter,
    private val schedulers: Schedulers
) : MvpPresenter<BirdsView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            birdsRepository
                .getWikiBirds()
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showBirds,
                    viewState::showError,
                    )
    }

    fun displayBird(bird: WikiBird) {
        router.navigateTo(BirdScreen(bird.title))
    }

    override fun onDestroy() {
        disposables.dispose()
    }

}