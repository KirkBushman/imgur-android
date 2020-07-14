package com.kirkbushman.sampleapp.activities

import android.content.Context
import android.content.Intent
import com.kirkbushman.imgur.ImgurClient
import com.kirkbushman.imgur.models.Gallery
import com.kirkbushman.sampleapp.activities.base.BaseSearchPrintActivity

class GalleryActivity : BaseSearchPrintActivity<Gallery?>() {

    companion object {

        fun start(context: Context) {

            val intent = Intent(context, GalleryActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun fetchItem(client: ImgurClient, query: String): Gallery? {

        return client.gallery(query)
    }
}
