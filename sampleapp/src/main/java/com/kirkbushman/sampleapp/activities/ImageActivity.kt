package com.kirkbushman.sampleapp.activities

import android.content.Context
import android.content.Intent
import com.kirkbushman.imgur.ImgurClient
import com.kirkbushman.imgur.models.Image
import com.kirkbushman.sampleapp.activities.base.BaseSearchPrintActivity

class ImageActivity : BaseSearchPrintActivity<Image?>() {

    companion object {

        fun start(context: Context) {

            val intent = Intent(context, ImageActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun fetchItem(client: ImgurClient, query: String): Image? {

        return client.image(query)
    }
}
