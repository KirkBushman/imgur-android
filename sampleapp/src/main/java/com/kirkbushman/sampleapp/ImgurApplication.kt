package com.kirkbushman.sampleapp

import android.app.Application
import com.kirkbushman.imgur.ImgurClient
import com.kirkbushman.imgur.auth.UserlessCredentials
import org.xmlpull.v1.XmlPullParser

class ImgurApplication : Application() {

    companion object {

        private const val LOGGING = true

        var instance: ImgurApplication? = null
    }

    private var client: ImgurClient? = null

    override fun onCreate() {
        super.onCreate()

        instance = this
    }

    fun getClient(): ImgurClient? {
        return client
    }

    fun loadClient() {

        val creds = loadCredsFromXmlFile()
        client = ImgurClient(creds, LOGGING)
    }

    private fun loadCredsFromXmlFile(): UserlessCredentials {
        val xpp = resources.getXml(R.xml.credentials)

        var clientId = ""
        var clientSecret = ""

        while (xpp.eventType != XmlPullParser.END_DOCUMENT) {

            when (xpp.eventType) {

                XmlPullParser.START_TAG -> {

                    when (xpp.name) {
                        "clientId" -> clientId = xpp.nextText()
                        "clientSecret" -> clientSecret = xpp.nextText()
                    }
                }
            }

            xpp.next()
        }

        return UserlessCredentials(clientId)
    }
}
