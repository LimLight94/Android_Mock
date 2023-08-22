package com.lgcns.tct_template

import android.app.Application
import timber.log.Timber

class TctApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}