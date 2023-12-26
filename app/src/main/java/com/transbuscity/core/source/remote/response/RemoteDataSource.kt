package com.transbuscity.core.source.remote.response

import com.transbuscity.core.source.remote.network.ApiService

class RemoteDataSource(val api: ApiService) {

    suspend fun  getJadwal() = api.getJadwal()

    suspend fun  getJadwalAsal() = api.getJadwalAsal()

    suspend fun  getJadwalTujuan() = api.getJadwalTujuan()
}