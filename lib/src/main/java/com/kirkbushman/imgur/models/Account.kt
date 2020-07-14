package com.kirkbushman.imgur.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Account(

    @Json(name = "id")
    val id: Long,

    @Json(name = "cover")
    val coverUrl: String,

    @Json(name = "cover_name")
    val coverName: String,

    @Json(name = "url")
    val url: String,

    @Json(name = "bio")
    val bio: String?,

    @Json(name = "avatar")
    val avatarUrl: String,

    @Json(name = "avatar_name")
    val avatarName: String,

    @Json(name = "reputation")
    val reputation: Int,

    @Json(name = "reputation_name")
    val reputationName: String,

    @Json(name = "created")
    val created: Long,

    @Json(name = "is_blocked")
    val isBlocked: Boolean

) : Parcelable
