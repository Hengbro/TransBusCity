package com.transbuscity.core.di

import com.transbuscity.core.repo.JadwalRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { JadwalRepository(get(), get()) }
}
