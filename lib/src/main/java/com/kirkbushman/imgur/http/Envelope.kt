package com.kirkbushman.imgur.http

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Envelope<T : Parcelable>(

    val data: T,

    val success: Boolean,
    val status: Int

) : Parcelable
