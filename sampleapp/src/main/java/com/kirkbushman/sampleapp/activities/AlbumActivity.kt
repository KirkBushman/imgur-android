package com.kirkbushman.sampleapp.activities

import android.content.Context
import android.content.Intent
import com.kirkbushman.imgur.ImgurClient
import com.kirkbushman.imgur.models.Album
import com.kirkbushman.sampleapp.activities.base.BaseSearchPrintActivity

class AlbumActivity : BaseSearchPrintActivity<Album?>() {

    companion object {

        fun start(context: Context) {

            val intent = Intent(context, AlbumActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun fetchItem(client: ImgurClient, query: String): Album? {

        return client.album(query)
    }
}
