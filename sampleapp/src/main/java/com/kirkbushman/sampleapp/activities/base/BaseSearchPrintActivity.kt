package com.kirkbushman.sampleapp.activities.base

import android.os.Bundle
import com.kirkbushman.imgur.ImgurClient
import com.kirkbushman.sampleapp.ImgurApplication
import com.kirkbushman.sampleapp.R
import com.kirkbushman.sampleapp.utils.doAsync
import kotlinx.android.synthetic.main.activity_search_print.*

abstract class BaseSearchPrintActivity<T> : BaseActivity(R.layout.activity_search_print) {

    private val client by lazy { ImgurApplication.instance?.getClient() }

    private var item: T? = null

    abstract fun fetchItem(client: ImgurClient, query: String): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }

        search_bttn.setOnClickListener {

            val query = query.text.trim().toString()

            doAsync(
                doWork = { item = fetchItem(client!!, query) },
                onPost = { obj_text.text = item.toString() }
            )
        }
    }
}
