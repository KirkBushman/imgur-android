package com.kirkbushman.imgur.http

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class ListEnvelope<T : Parcelable>(

    val data: List<T>,

    val success: Boolean,
    val status: Int

) : Parcelable
