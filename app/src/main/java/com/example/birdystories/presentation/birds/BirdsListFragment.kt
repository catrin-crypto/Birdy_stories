package com.example.birdystories.presentation.birds

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.birdystories.R.layout.fragment_birds_list
import com.example.birdystories.databinding.FragmentBirdsListBinding
import moxy.MvpAppCompatFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.birdystories.BirdyStories.Navigation.router
import com.example.birdystories.data.api.WikiBird
import com.example.birdystories.arguments
import com.example.birdystories.data.bird.datasource.WikiBirdsDataSourceImpl
import com.example.birdystories.data.repository.WikiBirdsRepositoryFactory
import com.example.birdystories.schedulers.SchedulersFactory
import moxy.ktx.moxyPresenter


class BirdsListFragment : MvpAppCompatFragment(fragment_birds_list), BirdsView,BirdsListRvAdapter.Delegate {

        companion object {
            fun newInstance(): Fragment =
                BirdsListFragment()
                    .arguments()

        }

        private val presenter: BirdsListPresenter by moxyPresenter {
            BirdsListPresenter(
                birdsRepository =  WikiBirdsRepositoryFactory.create(),
                router = router,
                schedulers = SchedulersFactory.create()
            )
        }

        private val viewBinding: FragmentBirdsListBinding by viewBinding()
        private var birdsListAdapter : BirdsListRvAdapter? = null

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            birdsListAdapter = BirdsListRvAdapter(delegate = this)
            birdsListAdapter
            viewBinding.rvBirds.adapter = birdsListAdapter
        }


    override fun showBirds(birds: List<WikiBird>) {
        birdsListAdapter?.submitList(birds)
    }

    override fun showError(error: Throwable) {
            error.message?.let{Log.d("Error",it)}
            Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
        }

        override fun onBirdPicked(bird: WikiBird) =
            presenter.displayBird(bird)

}