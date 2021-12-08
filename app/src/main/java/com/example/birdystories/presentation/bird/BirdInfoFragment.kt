package com.example.birdystories.presentation.bird

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.birdystories.R
import com.example.birdystories.databinding.FragmentBirdInfoBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.birdystories.data.api.WikiBird

class BirdInfoFragment : Fragment() {

    private val viewBinding: FragmentBirdInfoBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bird_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // viewBinding.birdTitle.text = WikiBird.

    }
    companion object {

        @JvmStatic
        fun newInstance(): Fragment =
            BirdInfoFragment()
    }
}