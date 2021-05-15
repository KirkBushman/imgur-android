package com.kirkbushman.sampleapp.activities.base

import android.os.Bundle
import com.kirkbushman.imgur.ImgurClient
import com.kirkbushman.sampleapp.ImgurApplication
import com.kirkbushman.sampleapp.databinding.ActivitySearchPrint2Binding
import com.kirkbushman.sampleapp.utils.doAsync

abstract class BaseSearchPrint2Activity<T> : BaseActivity() {

    private lateinit var binding: ActivitySearchPrint2Binding

    private val client by lazy { ImgurApplication.instance?.getClient() }

    private var item: T? = null

    abstract fun fetchItem(client: ImgurClient, query: String, query2: String): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchPrint2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }

        binding.searchBttn.setOnClickListener {

            val query = binding.query.text.trim().toString()
            val query2 = binding.query2.text.trim().toString()

            doAsync(
                doWork = { item = fetchItem(client!!, query, query2) },
                onPost = { binding.objText.text = item.toString() }
            )
        }
    }
}
