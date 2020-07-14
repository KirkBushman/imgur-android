package com.kirkbushman.imgur.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Gallery(

    @Json(name = "id")
    val id: String,

    @Json(name = "cover")
    val coverHash: String,

    @Json(name = "title")
    val title: String,

    @Json(name = "description")
    val description: String?,

    @Json(name = "datetime")
    val datetime: Long,

    @Json(name = "cover_width")
    val coverWidth: Int,

    @Json(name = "cover_height")
    val coverHeight: Int,

    @Json(name = "account_url")
    val accountUrl: String,

    @Json(name = "account_id")
    val accountId: Long,

    @Json(name = "privacy")
    val privacy: String,

    @Json(name = "layout")
    val layout: String,

    @Json(name = "views")
    val views: Int,

    @Json(name = "link")
    val link: String,

    @Json(name = "ups")
    val ups: Int,

    @Json(name = "downs")
    val downs: Int,

    @Json(name = "points")
    val points: Int,

    @Json(name = "score")
    val score: Int,

    @Json(name = "is_album")
    val isAlbum: Boolean,

    @Json(name = "favorite")
    val favorite: Boolean,

    @Json(name = "nsfw")
    val isNsfw: Boolean,

    @Json(name = "section")
    val section: String,

    @Json(name = "comment_count")
    val commentCount: Int,

    @Json(name = "favorite_count")
    val favoriteCount: Int,

    @Json(name = "topic")
    val topic: String,

    @Json(name = "topic_id")
    val topicId: Int,

    @Json(name = "images_count")
    val imagesCount: Int,

    @Json(name = "in_gallery")
    val inGallery: Boolean,

    @Json(name = "is_ad")
    val isAd: Boolean,

    @Json(name = "in_most_viral")
    val inMostViral: Boolean,

    @Json(name = "images")
    val images: List<Image>

) : Parcelable
