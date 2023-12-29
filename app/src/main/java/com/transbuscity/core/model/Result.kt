package com.transbuscity.core.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Result(
    val armada: String?,
    val detail_rute: String?,
    val id: String?,
    val id_rute: String?,
    val jam: String?,
    val kapasitas: Int?,
    val keterangan: String?,
    val kode_jadwal: String?,
    val layanan: String?,
    val list_outlet_dropoff: String?,
    val list_outlet_pickup: String?,
    val list_outlet_transit: String?,
    val rute: String?,
    val rute_kota: String?,
    val terisi: Int?,
    val tersedia: Int?,
    val tujuan: JadwalTujuan? = null,

) : Parcelable