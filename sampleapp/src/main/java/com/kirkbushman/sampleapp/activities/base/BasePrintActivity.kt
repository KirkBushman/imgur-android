package com.kirkbushman.sampleapp.activities.base

import android.os.Bundle
import com.kirkbushman.imgur.ImgurClient
import com.kirkbushman.sampleapp.ImgurApplication
import com.kirkbushman.sampleapp.databinding.ActivityPrintBinding
import com.kirkbushman.sampleapp.utils.doAsync

abstract class BasePrintActivity<T> : BaseActivity() {

    private lateinit var binding: ActivityPrintBinding

    private val client by lazy { ImgurApplication.instance?.getClient() }

    private var item: T? = null

    abstract fun fetchItem(client: ImgurClient): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPrintBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }

        doAsync(
            doWork = { item = fetchItem(client!!) },
            onPost = { binding.objText.text = item.toString() }
        )
    }
}
