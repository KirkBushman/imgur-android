package com.kirkbushman.sampleapp.activities.base

import android.os.Bundle
import com.kirkbushman.imgur.ImgurClient
import com.kirkbushman.sampleapp.ImgurApplication
import com.kirkbushman.sampleapp.databinding.ActivitySearchPrintBinding
import com.kirkbushman.sampleapp.utils.doAsync

abstract class BaseSearchPrintActivity<T> : BaseActivity() {

    private lateinit var binding: ActivitySearchPrintBinding

    private val client by lazy { ImgurApplication.instance?.getClient() }

    private var item: T? = null

    abstract fun fetchItem(client: ImgurClient, query: String): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchPrintBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }

        binding.searchBttn.setOnClickListener {

            val query = binding.query.text.trim().toString()

            doAsync(
                doWork = { item = fetchItem(client!!, query) },
                onPost = { binding.objText.text = item.toString() }
            )
        }
    }
}
