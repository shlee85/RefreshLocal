package com.example.changelocale


import android.app.Application
import android.content.Context
import com.example.changelocale.LocaleHelper

class MainApplication : Application() {
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"))
    }
}