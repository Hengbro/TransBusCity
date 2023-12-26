package com.transbuscity.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class JadwalTujuan(
    val id: String,
    val kapasitas: Int,
    val nama: String,
    val rute: String,
    val tarif: Int,
    val tarif_str: String,
    val terisi: Int,
    val tersedia: Int
): Parcelable