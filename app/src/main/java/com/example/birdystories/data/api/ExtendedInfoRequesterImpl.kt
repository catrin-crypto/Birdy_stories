package com.example.birdystories.data.api

import android.content.Context
import android.content.Intent
import android.net.Uri
import javax.inject.Inject

class ExtendedInfoRequesterImpl
@Inject constructor(
    val context: Context
) : ExtendedInfoRequester {
    override fun requestExtendedInfo(subject: String) {
        val sharingIntent = Intent(Intent.ACTION_VIEW)
        sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        sharingIntent.setData(Uri.parse("https://ru.wikipedia.org/wiki/${subject}"))

        val chooserIntent = Intent.createChooser(sharingIntent, "Open With")
        chooserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        context.startActivity(chooserIntent)

    }

}