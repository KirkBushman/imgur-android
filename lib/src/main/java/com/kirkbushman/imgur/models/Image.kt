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
    val isAnimated: Boolean,

    @Json(name = "width")
    val width: Int,

    @Json(name = "height")
    val height: Int,

    @Json(name = "size")
    val size: Long,

    @Json(name = "views")
    val views: Int,

    @Json(name = "bandwidth")
    val bandwidth: Long,

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
    val link: String,

    @Json(name = "mp4")
    val mp4Link: String?,

    @Json(name = "mp4_size")
    val mp4Size: Long?,

    @Json(name = "gifv")
    val gifvLink: String?,

    @Json(name = "hls")
    val hlsLink: String?,

    @Json(name = "ups")
    val ups: Int?,

    @Json(name = "downs")
    val downs: Int?,

    @Json(name = "points")
    val points: Int?,

    @Json(name = "score")
    val score: Int?

) : Parcelable
