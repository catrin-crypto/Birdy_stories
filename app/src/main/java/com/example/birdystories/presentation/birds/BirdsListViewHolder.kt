package com.example.birdystories.presentation.birds

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.birdystories.click
import com.example.birdystories.data.api.WikiBird
import com.example.birdystories.databinding.BirdsListRvItemBinding

class BirdsListViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val viewBinding:BirdsListRvItemBinding by viewBinding()

    fun bind(model: WikiBird,delegate : BirdsListRvAdapter.Delegate?) {
        with(viewBinding) {
            model.thumbnail?.let{
            Glide.with(birdImage)
                .load(it.sourceT)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(birdImage)}
            birdTitle.text = model.title
            root.click{delegate?.onBirdPicked(model)}
        }
    }
}