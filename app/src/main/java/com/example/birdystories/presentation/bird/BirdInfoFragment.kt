package com.example.birdystories.presentation.bird

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.ScaleAnimation
import android.widget.Toast
import com.example.birdystories.R
import com.example.birdystories.R.layout.fragment_bird_info
import com.example.birdystories.databinding.FragmentBirdInfoBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.example.birdystories.arguments
import com.example.birdystories.data.api.WikiBird
import com.example.birdystories.data.repository.WikiBirdsRepositoryFactory
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import com.bumptech.glide.request.target.Target

class BirdInfoFragment : MvpAppCompatFragment(fragment_bird_info),BirdView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bird_info, container, false)
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

    @Suppress("unused")
    private val presenter: BirdPresenter by moxyPresenter {
        BirdPresenter(
            birdTitle = birdTitle,
            wikiBirdsRepository =  WikiBirdsRepositoryFactory.create()
        )
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
        with(viewBinding){
            this.birdTitle.text = bird.title
            bird.extract?.let{
            this.birdDescription.text = it}
            bird.original?.let{
            Glide.with(this.birdPhoto)
                .load(it.sourceO)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(p0: GlideException?, p1: Any?, p2: Target<Drawable>?, p3: Boolean): Boolean {
                        p0?.message?.let{Log.d("Error",it)
                            Toast.makeText(
                                context,
                                "error:" + it,
                                Toast.LENGTH_LONG
                            ).show()
                            p0.printStackTrace()}
                        return true
                    }
                    override fun onResourceReady(p0: Drawable?, p1: Any?, p2: Target<Drawable>?, p3: DataSource?, p4: Boolean): Boolean {
                        scaleView(birdPhoto, 0.01f, 1f)
                        return false
                    }
                })
                .into(this.birdPhoto)
            }
            viewBinding.wikiBtn.setOnClickListener  {
                startActivity(Intent(Intent.ACTION_VIEW).apply {
                    data =
                        Uri.parse("https://ru.wikipedia.org/wiki/${bird.title}")
                })
            }
        }
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

}