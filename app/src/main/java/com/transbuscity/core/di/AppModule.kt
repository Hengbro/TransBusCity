package com.transbuscity.core.di

import androidx.room.Room
import com.transbuscity.core.source.local.LocalDataSource
import com.transbuscity.core.source.remote.network.ApiConfig
import com.transbuscity.core.source.remote.response.RemoteDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    single { ApiConfig.provideApiService }

    single { RemoteDataSource(get()) }

    single { LocalDataSource() }

}