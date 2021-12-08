package com.example.birdystories.presentation.birds

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.birdystories.data.api.WikiBird
import com.example.birdystories.databinding.BirdsListRvItemBinding

class BirdsListViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val viewBinding:BirdsListRvItemBinding by viewBinding()

    fun bind(model: WikiBird) {
        with(viewBinding) {
            Glide.with(birdImage)
                .load(model.thumbnail.source)
                .into(birdImage)
            birdTitle.text = model.title
        }
    }
}