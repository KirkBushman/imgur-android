package com.kirkbushman.sampleapp.activities

import android.content.Context
import android.content.Intent
import com.kirkbushman.imgur.ImgurClient
import com.kirkbushman.imgur.models.Account
import com.kirkbushman.sampleapp.activities.base.BaseSearchPrintActivity

class AccountActivity : BaseSearchPrintActivity<Account?>() {

    companion object {

        fun start(context: Context) {

            val intent = Intent(context, AccountActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun fetchItem(client: ImgurClient, query: String): Account? {

        return client.account(query)
    }
}
