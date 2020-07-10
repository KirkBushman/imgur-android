package com.kirkbushman.imgur

import com.kirkbushman.imgur.http.Envelope
import com.kirkbushman.imgur.models.Album
import com.kirkbushman.imgur.models.Image
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path

interface ImgurApi2 {

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
}
