package com.example.birdystories.presentation.birds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.birdystories.R.layout.fragment_birds_list
import com.example.birdystories.databinding.FragmentBirdsListBinding
import moxy.MvpAppCompatFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.ktx.moxyPresenter


class BirdsListFragment : MvpAppCompatFragment(fragment_birds_list), BirdsView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
//    private val presenter: UsersPresenter by moxyPresenter {
//        UsersPresenter(
//            userRepository = GitHubUserRepositoryFactory.create(),
//            router = router,
//            schedulers = SchedulersFactory.create()
//        )
//    }
    private val viewBinding: FragmentBirdsListBinding by viewBinding()
    //private var birdsAdapter : BirdsAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        usersAdapter = UsersAdapter(delegate = this)
//        viewBinding.users.adapter = usersAdapter
    }
//    override fun showUsers(users: List<GitHubUserViewModel>) {
//        usersAdapter?.submitList(users)
//    }

//    override fun showError(error: Throwable) {
//        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
//    }
//
//    override fun onUserPicked(user: GitHubUserViewModel) =
//        presenter.displayUser(user)

    companion object {
        @JvmStatic
        fun newInstance(): Fragment =
            BirdsListFragment()
    }
}