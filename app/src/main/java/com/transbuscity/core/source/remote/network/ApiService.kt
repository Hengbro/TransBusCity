package com.transbuscity.core.source.remote.network

import com.transbuscity.core.model.JadwalAsal
import com.transbuscity.core.model.JadwalTujuan
import com.transbuscity.core.model.Result
import com.transbuscity.core.source.remote.response.base.BaseList
import com.transbuscity.core.source.remote.response.respon.tiketux
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/jadwal.json")
    suspend fun getJadwal(): Response<tiketux<Result>>

    @GET("/jadwal-asal.json")
    suspend fun getJadwalAsal(): Response<tiketux<JadwalAsal>>

    @GET("/jadwal-tujuan.json")
    suspend fun getJadwalTujuan(): Response<tiketux<JadwalTujuan>>

}