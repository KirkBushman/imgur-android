package com.kirkbushman.imgur

import com.kirkbushman.imgur.auth.UserlessCredentials
import com.kirkbushman.imgur.models.*
import com.kirkbushman.imgur.utils.Utils.buildRetrofit
import retrofit2.Retrofit

class ImgurClient(private val credentials: UserlessCredentials, logging: Boolean) {

    companion object {

        @Volatile
        private var retrofit: Retrofit? = null
        @Volatile
        private var api: ImgurApi? = null

        @Synchronized
        fun getRetrofit(logging: Boolean = false): Retrofit {
            return synchronized(this) {

                if (retrofit == null) {
                    retrofit = buildRetrofit(logging)
                }

                retrofit!!
            }
        }

        @Synchronized
        fun getApi(logging: Boolean = false): ImgurApi {
            return synchronized(this) {

                if (api == null) {
                    api = getRetrofit(logging).create(ImgurApi::class.java)
                }

                api!!
            }
        }
    }

    private val api by lazy { getApi(logging) }

    fun account(username: String): Account? {

        val authMap = getHeaderMap()
        val req = api.account(username, authMap)
        val res = req.execute()

        if (!res.isSuccessful) {
            return null
        }

        return res.body()?.data
    }

    fun image(imageHash: String): Image? {

        val authMap = getHeaderMap()
        val req = api.image(imageHash, authMap)
        val res = req.execute()

        if (!res.isSuccessful) {
            return null
        }

        return res.body()?.data
    }

    fun album(albumHash: String): Album? {

        val authMap = getHeaderMap()
        val req = api.album(albumHash, authMap)
        val res = req.execute()

        if (!res.isSuccessful) {
            return null
        }

        return res.body()?.data
    }

    fun albumImages(albumHash: String): List<Image>? {

        val authMap = getHeaderMap()
        val req = api.albumImages(albumHash, authMap)
        val res = req.execute()

        if (!res.isSuccessful) {
            return null
        }

        return res.body()?.data
    }

    fun albumImage(albumHash: String, imageHash: String): Image? {

        val authMap = getHeaderMap()
        val req = api.albumImage(albumHash, imageHash, authMap)
        val res = req.execute()

        if (!res.isSuccessful) {
            return null
        }

        return res.body()?.data
    }

    fun gallery(
        galleryHash: String,
        showViral: Boolean = true,
        showMature: Boolean = false,
        includeAlbumPrevious: Boolean = false
    ): Gallery? {

        val authMap = getHeaderMap()
        val req = api.gallery(
            galleryHash = galleryHash,
            showViral = showViral,
            showMature = showMature,
            includeAlbumPrevious = includeAlbumPrevious,
            header = authMap
        )

        val res = req.execute()
        if (!res.isSuccessful) {
            return null
        }

        return res.body()?.data
    }

    fun gallery(
        galleryHash: String,
        sort: GallerySort,
        showViral: Boolean = true,
        showMature: Boolean = false,
        includeAlbumPrevious: Boolean = false
    ): Gallery? {

        val authMap = getHeaderMap()
        val req = api.gallery(
            galleryHash = galleryHash,
            sort = sort.sortStr,
            showViral = showViral,
            showMature = showMature,
            includeAlbumPrevious = includeAlbumPrevious,
            header = authMap
        )

        val res = req.execute()
        if (!res.isSuccessful) {
            return null
        }

        return res.body()?.data
    }

    fun gallery(
        galleryHash: String,
        sort: GallerySort,
        window: GalleryWindow,
        showViral: Boolean = true,
        showMature: Boolean = false,
        includeAlbumPrevious: Boolean = false
    ): Gallery? {

        val authMap = getHeaderMap()
        val req = api.gallery(
            galleryHash = galleryHash,
            sort = sort.sortStr,
            window = window.windowStr,
            showViral = showViral,
            showMature = showMature,
            includeAlbumPrevious = includeAlbumPrevious,
            header = authMap
        )

        val res = req.execute()
        if (!res.isSuccessful) {
            return null
        }

        return res.body()?.data
    }

    private fun getHeaderMap(): HashMap<String, String> {
        return hashMapOf("Authorization" to "Client-ID ".plus(credentials.clientId))
    }
}
