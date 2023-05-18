package com.lgcns.tct_template

import android.app.Application
import logcat.AndroidLogcatLogger
import logcat.LogPriority

class TctApp: Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = LogPriority.VERBOSE)

    }
}