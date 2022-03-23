package com.sim2g.icbt

import android.app.Application
import dagger.Provides
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.*
import javax.inject.Inject

@HiltAndroidApp
class ICBTApp: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}