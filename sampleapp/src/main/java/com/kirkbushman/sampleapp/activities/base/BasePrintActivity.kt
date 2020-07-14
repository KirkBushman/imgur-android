package com.kirkbushman.sampleapp.activities.base

import android.os.Bundle
import com.kirkbushman.imgur.ImgurClient
import com.kirkbushman.sampleapp.ImgurApplication
import com.kirkbushman.sampleapp.R
import com.kirkbushman.sampleapp.utils.doAsync
import kotlinx.android.synthetic.main.activity_print.*

abstract class BasePrintActivity<T> : BaseActivity(R.layout.activity_print) {

    private val client by lazy { ImgurApplication.instance?.getClient() }

    private var item: T? = null

    abstract fun fetchItem(client: ImgurClient): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }

        doAsync(
            doWork = { item = fetchItem(client!!) },
            onPost = { obj_text.text = item.toString() }
        )
    }
}
