package com.kirkbushman.sampleapp.activities

import android.content.Context
import android.content.Intent
import com.kirkbushman.imgur.ImgurClient
import com.kirkbushman.imgur.models.Image
import com.kirkbushman.sampleapp.activities.base.BaseSearchPrintActivity

class AlbumImagesActivity : BaseSearchPrintActivity<List<Image>?>() {

    companion object {

        fun start(context: Context) {

            val intent = Intent(context, AlbumImagesActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun fetchItem(client: ImgurClient, query: String): List<Image>? {

        return client.albumImages(query)
    }
}
