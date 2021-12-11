package com.example.birdystories.presentation.birds

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.birdystories.data.api.WikiBird


object BirdsDiff : DiffUtil.ItemCallback<WikiBird>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: WikiBird, newItem: WikiBird): Boolean {
        return oldItem.pageid == newItem.pageid
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: WikiBird, newItem: WikiBird): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: WikiBird, newItem: WikiBird) = payload

}