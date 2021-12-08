package com.example.birdystories.data.api

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken


@Entity(tableName = "wiki_birds")
data class WikiBird(
    @PrimaryKey
    @SerializedName("pageid")
    val pageid: Int,
    @ColumnInfo
    @SerializedName("title")
    val title: String,
    @ColumnInfo
    @SerializedName("extract")
    val extract: String?,
    @ColumnInfo
    @Embedded
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailImage,
    @ColumnInfo
    @Embedded
    @SerializedName("original")
    val original: OriginalImage
)

class ThumbnailConverter {
    @TypeConverter
    fun fromThumbnailImage(thumbImage: ThumbnailImage?): String? {
        val type = object : TypeToken<ThumbnailImage>() {}.type
        return Gson().toJson(thumbImage, type)
    }

    @TypeConverter
    fun toThumbnailImage(imageString: String?): ThumbnailImage? {
        val type = object : TypeToken<ThumbnailImage>() {}.type
        return Gson().fromJson<ThumbnailImage>(imageString, type)
    }
}

data class ThumbnailImage(
    @SerializedName("source")
    val source : String,
    @SerializedName("width")
    val width : Int,
    @SerializedName("height")
    val height : Int
)
class OriginalConverter {
    @TypeConverter
    fun fromOriginalImage(originalImage: OriginalImage?): String? {
        val type = object : TypeToken<OriginalImage>() {}.type
        return Gson().toJson(originalImage, type)
    }

    @TypeConverter
    fun toOriginalImage(imageString: String?): OriginalImage? {
        val type = object : TypeToken<OriginalImage>() {}.type
        return Gson().fromJson<OriginalImage>(imageString, type)
    }
}
data class OriginalImage(
    @SerializedName("source")
    val source : String,
    @SerializedName("width")
    val width : Int,
    @SerializedName("height")
    val height : Int
)


data class WikiBirdQueryResponse(
    @SerializedName("batchcomplete")
    val batchcomplete : String,
    @SerializedName("query")
    val query : WikiBirdQueryContainer
)

data class WikiBirdQueryContainer(
    @SerializedName("pages")
    val pages : Map<String,WikiBird>
)