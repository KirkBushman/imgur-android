package com.kirkbushman.sampleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kirkbushman.sampleapp.activities.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ImgurApplication.instance?.loadClient()

        bttn_imgur_account.setOnClickListener {

            AccountActivity.start(this)
        }

        bttn_imgur_image.setOnClickListener {

            ImageActivity.start(this)
        }

        bttn_imgur_album.setOnClickListener {

            AlbumActivity.start(this)
        }

        bttn_imgur_album_images.setOnClickListener {

            AlbumImagesActivity.start(this)
        }

        bttn_imgur_album_image.setOnClickListener {

            AlbumImageActivity.start(this)
        }

        bttn_imgur_gallery.setOnClickListener {

            GalleryActivity.start(this)
        }
    }
}
