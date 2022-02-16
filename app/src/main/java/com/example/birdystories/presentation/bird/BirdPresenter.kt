package com.example.birdystories.presentation.bird

import com.example.birdystories.data.api.ExtendedInfoRequester
import com.example.birdystories.data.repository.WikiBirdsRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class BirdPresenter
@AssistedInject constructor(
    @Assisted("title")
    private val birdTitle: String,
    private val wikiBirdsRepository: WikiBirdsRepository,
    private val extendedInfoRequester: ExtendedInfoRequester
) : MvpPresenter<BirdView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            wikiBirdsRepository
                .getWikiBird(birdTitle)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(viewState::showBird)
                .subscribeOn(Schedulers.io())
                .subscribe({}, viewState::showError)
    }


    fun requestExtendedInfo() =
        extendedInfoRequester.requestExtendedInfo(birdTitle)

    override fun onDestroy() {
        disposables.clear()
    }
}