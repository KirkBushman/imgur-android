package com.kirkbushman.imgur

import com.kirkbushman.imgur.auth.UserlessCredentials
import com.kirkbushman.imgur.models.Album
import com.kirkbushman.imgur.models.Image
import com.kirkbushman.imgur.utils.Utils.buildRetrofit
import retrofit2.Retrofit

class ImgurClient(private val credentials: UserlessCredentials, logging: Boolean) {

    companion object {

        @Volatile
        private var retrofit: Retrofit? = null
        @Volatile
        private var api: ImgurApi2? = null

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
        fun getApi(logging: Boolean = false): ImgurApi2 {
            return synchronized(this) {

                if (api == null) {
                    api = getRetrofit(logging).create(ImgurApi2::class.java)
                }

                api!!
            }
        }
    }

    private val api = getApi(logging)

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

    private fun getHeaderMap(): HashMap<String, String> {
        return hashMapOf("Authorization" to "Client-ID ".plus(credentials.clientId))
    }
}