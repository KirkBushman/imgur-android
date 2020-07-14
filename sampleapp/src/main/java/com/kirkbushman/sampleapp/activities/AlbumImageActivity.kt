package com.kirkbushman.sampleapp.activities

import android.content.Context
import android.content.Intent
import com.kirkbushman.imgur.ImgurClient
import com.kirkbushman.imgur.models.Image
import com.kirkbushman.sampleapp.activities.base.BaseSearchPrint2Activity

class AlbumImageActivity : BaseSearchPrint2Activity<Image?>() {

    companion object {

        fun start(context: Context) {

            val intent = Intent(context, AlbumImageActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun fetchItem(client: ImgurClient, query: String, query2: String): Image? {

        return client.albumImage(query, query2)
    }
}
