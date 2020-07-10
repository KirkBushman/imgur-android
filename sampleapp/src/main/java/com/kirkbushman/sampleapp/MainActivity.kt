package com.kirkbushman.sampleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kirkbushman.sampleapp.activities.ImageActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ImgurApplication.instance?.loadClient()

        bttn_imgur_image.setOnClickListener {

            ImageActivity.start(this)
        }
    }
}
