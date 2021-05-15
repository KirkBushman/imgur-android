package com.kirkbushman.sampleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kirkbushman.sampleapp.activities.*
import com.kirkbushman.sampleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ImgurApplication.instance?.loadClient()

        binding.bttnImgurAccount.setOnClickListener {

            AccountActivity.start(this)
        }

        binding.bttnImgurImage.setOnClickListener {

            ImageActivity.start(this)
        }

        binding.bttnImgurAlbum.setOnClickListener {

            AlbumActivity.start(this)
        }

        binding.bttnImgurAlbumImages.setOnClickListener {

            AlbumImagesActivity.start(this)
        }

        binding.bttnImgurAlbumImage.setOnClickListener {

            AlbumImageActivity.start(this)
        }

        binding.bttnImgurGallery.setOnClickListener {

            GalleryActivity.start(this)
        }
    }
}
