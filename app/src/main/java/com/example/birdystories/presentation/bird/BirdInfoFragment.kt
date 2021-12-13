package com.example.birdystories.presentation.bird


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.birdystories.R.layout.fragment_bird_info
import com.example.birdystories.databinding.FragmentBirdInfoBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.squareup.picasso.Picasso
import com.example.birdystories.arguments
import com.example.birdystories.data.api.WikiBird
import com.example.birdystories.presentation.abs.AbsFragment
import moxy.ktx.moxyPresenter
import com.squareup.picasso.Callback
import javax.inject.Inject

class BirdInfoFragment : AbsFragment(fragment_bird_info), BirdView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(fragment_bird_info, container, false)
    }

    private val viewBinding: FragmentBirdInfoBinding by viewBinding()

    companion object {

        private const val ARG_BIRD_TITLE = "arg_bird_title"

        fun newInstance(birdTitle: String): Fragment =
            BirdInfoFragment()
                .arguments(ARG_BIRD_TITLE to birdTitle)
    }

    private val birdTitle: String by lazy {
        arguments?.getString(ARG_BIRD_TITLE).orEmpty()
    }

    @Inject
    lateinit var presenterFactory: WikiBirdPresenterAssistedFactory


    private val presenter: BirdPresenter by moxyPresenter {
        presenterFactory.create(birdTitle)
    }

    fun scaleView(v: View, startScale: Float, endScale: Float) {
        val anim: Animation = ScaleAnimation(
            startScale, endScale,  // Start and end values for the X axis scaling
            startScale, endScale,  // Start and end values for the Y axis scaling
            Animation.RELATIVE_TO_SELF, 0.5f,  // Pivot point of X scaling
            Animation.RELATIVE_TO_SELF, 0.5f // Pivot point of Y scaling
        )
        anim.fillAfter = true // Needed to keep the result of the animation
        anim.duration = 2000
        anim.interpolator = DecelerateInterpolator()
        v.startAnimation(anim)
    }

    override fun showBird(bird: WikiBird) {
        with(viewBinding) {
            this.birdTitle.text = bird.title
            bird.extract?.let {
                this.birdDescription.text = it
            }
            bird.original?.let {
                Picasso.get()
                    .load(it.sourceO)
                    .into(this.birdPhoto, object : Callback {
                        override fun onSuccess() {
                            scaleView(birdPhoto, 0.01f, 1f)
                            birdPhoto.getLayoutParams().height = RelativeLayout.LayoutParams.WRAP_CONTENT
                            birdPhoto.requestLayout()
                            birdDescription.requestLayout()
                            wikiBtn.requestLayout()
                        }

                        override fun onError(e: Exception?) {
                            Toast.makeText(
                                context,
                                "error:" + e.toString(),
                                Toast.LENGTH_LONG
                            ).show()
                            e?.printStackTrace()
                        }
                    })

            }
            viewBinding.wikiBtn.setOnClickListener {
                presenter.requestExtendedInfo()
            }
        }
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

}