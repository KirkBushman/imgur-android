package com.kirkbushman.imgur.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Album(

    @Json(name = "id")
    val id: String,

    @Json(name = "title")
    val title: String?,

    @Json(name = "description")
    val description: String?,

    @Json(name = "datetime")
    val datetime: Long,

    @Json(name = "cover")
    val coverHash: String?,

    @Json(name = "cover_width")
    val coverWidth: Int?,

    @Json(name = "cover_height")
    val coverHeight: Int?,

    @Json(name = "account_id")
    val accountId: Int?,

    @Json(name = "account_url")
    val accountUrl: String?,

    @Json(name = "privacy")
    val privacy: String,

    @Json(name = "views")
    val views: Int,

    @Json(name = "favorite")
    val favorite: Boolean,

    @Json(name = "nsfw")
    val isNsfw: Boolean,

    @Json(name = "section")
    val section: String?,

    @Json(name = "is_ad")
    val isAd: Boolean,

    @Json(name = "in_gallery")
    val inGallery: Boolean,

    @Json(name = "link")
    val link: String,

    @Json(name = "images_count")
    val imagesCount: Int,

    @Json(name = "is_album")
    val isAlbum: Boolean,

    @Json(name = "images")
    val images: List<Image>

) : Parcelable
