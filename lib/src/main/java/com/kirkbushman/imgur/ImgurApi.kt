package com.kirkbushman.imgur

import com.kirkbushman.imgur.http.Envelope
import com.kirkbushman.imgur.http.ListEnvelope
import com.kirkbushman.imgur.models.Account
import com.kirkbushman.imgur.models.Album
import com.kirkbushman.imgur.models.Gallery
import com.kirkbushman.imgur.models.Image
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurApi {

    @GET("/3/account/{username}")
    fun account(
        @Path("username") username: String,
        @HeaderMap header: HashMap<String, String>
    ): Call<Envelope<Account>>

    @GET("/3/image/{imageHash}")
    fun image(
        @Path("imageHash") imageHash: String,
        @HeaderMap header: HashMap<String, String>
    ): Call<Envelope<Image>>

    @GET("/3/album/{albumHash}")
    fun album(
        @Path("albumHash") albumHash: String,
        @HeaderMap header: HashMap<String, String>
    ): Call<Envelope<Album>>

    @GET("/3/album/{albumHash}/images")
    fun albumImages(
        @Path("albumHash") albumHash: String,
        @HeaderMap header: HashMap<String, String>
    ): Call<ListEnvelope<Image>>

    @GET("/3/album/{albumHash}/image/{imageHash}")
    fun albumImage(
        @Path("albumHash") albumHash: String,
        @Path("imageHash") imageHash: String,
        @HeaderMap header: HashMap<String, String>
    ): Call<Envelope<Image>>

    @GET("/3/gallery/{galleryHash}")
    fun gallery(
        @Path("galleryHash") galleryHash: String,
        @Query("showViral") showViral: Boolean,
        @Query("mature") showMature: Boolean,
        @Query("album_previews") includeAlbumPrevious: Boolean,
        @HeaderMap header: HashMap<String, String>
    ): Call<Envelope<Gallery>>

    @GET("/3/gallery/{galleryHash}/{sort}")
    fun gallery(
        @Path("galleryHash") galleryHash: String,
        @Path("sort") sort: String,
        @Query("showViral") showViral: Boolean,
        @Query("mature") showMature: Boolean,
        @Query("album_previews") includeAlbumPrevious: Boolean,
        @HeaderMap header: HashMap<String, String>
    ): Call<Envelope<Gallery>>

    @GET("/3/gallery/{galleryHash}/{sort}/{window}")
    fun gallery(
        @Path("galleryHash") galleryHash: String,
        @Path("sort") sort: String,
        @Path("window") window: String,
        @Query("showViral") showViral: Boolean,
        @Query("mature") showMature: Boolean,
        @Query("album_previews") includeAlbumPrevious: Boolean,
        @HeaderMap header: HashMap<String, String>
    ): Call<Envelope<Gallery>>
}
