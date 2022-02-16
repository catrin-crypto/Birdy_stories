package com.example.birdystories.data.api

import com.google.gson.annotations.SerializedName

data class WikiBirdName (
    @SerializedName("title")
    val title:String,
    @SerializedName("exists")
    val exists:Boolean
    )

data class WikiBirdParseResponse(
    @SerializedName("parse")
    val parse :WikiListContainer
)

data class WikiListContainer(
    @SerializedName("links")
    val links : List<WikiBirdName>
)