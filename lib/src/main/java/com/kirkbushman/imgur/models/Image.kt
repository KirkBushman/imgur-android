package com.kirkbushman.imgur.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Image(

    @Json(name = "id")
    val id: String,

    @Json(name = "title")
    val title: String?,

    @Json(name = "description")
    val description: String?,

    @Json(name = "datetime")
    val datetime: Long,

    @Json(name = "type")
    val type: String,

    @Json(name = "animated")
    val animated: Boolean,

    @Json(name = "width")
    val width: Int,

    @Json(name = "height")
    val height: Int,

    @Json(name = "size")
    val size: Long,

    @Json(name = "views")
    val views: Int,

    @Json(name = "favorite")
    val favorite: Boolean,

    @Json(name = "nsfw")
    val isNsfw: Boolean?,

    @Json(name = "section")
    val section: String?,

    @Json(name = "is_ad")
    val isAd: Boolean,

    @Json(name = "in_most_viral")
    val inMostViral: Boolean,

    @Json(name = "has_sound")
    val hasSound: Boolean,

    @Json(name = "edited")
    val edited: Long,

    @Json(name = "in_gallery")
    val inGallery: Boolean,

    @Json(name = "link")
    val link: String

) : Parcelable
