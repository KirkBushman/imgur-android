package com.kirkbushman.imgur.http

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ListEnvelope<T>(

    val data: List<T>,

    val success: Boolean,
    val status: Int

)
