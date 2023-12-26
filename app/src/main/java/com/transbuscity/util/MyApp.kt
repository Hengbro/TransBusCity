package com.transbuscity.util

import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.transbuscity.core.di.appModule
import com.transbuscity.core.di.repositoryModule
import com.transbuscity.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Kotpref.init(this)
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, viewModelModule, repositoryModule))
        }
    }
}