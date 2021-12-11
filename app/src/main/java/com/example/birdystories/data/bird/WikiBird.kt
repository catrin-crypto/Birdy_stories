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
    @Embedded(prefix = "thumb_")
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailImage?,
    @Embedded(prefix = "orig_")
    @SerializedName("original")
    val original: OriginalImage?
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
    val sourceT : String,
    @SerializedName("width")
    val widthT : Int,
    @SerializedName("height")
    val heightT : Int
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
    val sourceO : String,
    @SerializedName("width")
    val widthO : Int,
    @SerializedName("height")
    val heightO : Int
)


data class WikiBirdQueryResponse(
    @SerializedName("batchcomplete")
    val batchcomplete : String?,
    @SerializedName("query")
    val query : WikiBirdQueryContainer
)

data class WikiBirdQueryContainer(
    @SerializedName("pages")
    val pages : Map<String,WikiBird>
)