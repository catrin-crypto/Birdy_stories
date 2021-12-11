package com.example.birdystories.presentation.birds


import com.example.birdystories.data.api.WikiBird
import com.example.birdystories.data.bird.datasource.WikiBirdsDataSource
import com.example.birdystories.data.repository.WikiBirdsRepository
import com.example.birdystories.presentation.bird.BirdScreen
import com.example.birdystories.schedulers.Schedulers
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.core.Observable

import moxy.MvpPresenter


class BirdsListPresenter(
    private val birdsRepository: WikiBirdsRepository,
    private val router: Router,
    private val schedulers: Schedulers
): MvpPresenter<BirdsView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            birdsRepository
                .getWikiBirds()
                .observeOn(schedulers.background())
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showBirds,
                    viewState::showError
                )
    }

    fun displayBird(bird: WikiBird) {
        router.navigateTo(BirdScreen(bird.title))
    }

    override fun onDestroy() {
        disposables.dispose()
    }

}