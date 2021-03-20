package com.kirkbushman.imgur.http

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Envelope<T>(

    val data: T,

    val success: Boolean,
    val status: Int
)
