package com.kirkbushman.sampleapp.activities.base

import android.os.Bundle
import com.kirkbushman.imgur.ImgurClient
import com.kirkbushman.sampleapp.ImgurApplication
import com.kirkbushman.sampleapp.R
import com.kirkbushman.sampleapp.utils.doAsync
import kotlinx.android.synthetic.main.activity_search_print_2.*

abstract class BaseSearchPrint2Activity<T> : BaseActivity(R.layout.activity_search_print_2) {

    private val client by lazy { ImgurApplication.instance?.getClient() }

    private var item: T? = null

    abstract fun fetchItem(client: ImgurClient, query: String, query2: String): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }

        search_bttn.setOnClickListener {

            val query = query.text.trim().toString()
            val query2 = query2.text.trim().toString()

            doAsync(
                doWork = { item = fetchItem(client!!, query, query2) },
                onPost = { obj_text.text = item.toString() }
            )
        }
    }
}
