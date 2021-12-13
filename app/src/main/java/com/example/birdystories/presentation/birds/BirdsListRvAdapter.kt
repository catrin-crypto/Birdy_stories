package com.example.birdystories.presentation.birds

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.birdystories.R.layout.birds_list_rv_item
import com.example.birdystories.data.api.WikiBird


class BirdsListRvAdapter(private val delegate: Delegate?) :
    ListAdapter<WikiBird, BirdsListViewHolder>(BirdsDiff) {

    interface Delegate {
        fun onBirdPicked(bird: WikiBird)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirdsListViewHolder =
        BirdsListViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(birds_list_rv_item, parent, false)
        )

    override fun onBindViewHolder(holder: BirdsListViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)


}