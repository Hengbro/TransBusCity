package com.transbuscity.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class JadwalAsal(
    val alamat: String,
    val id: String,
    val jam_berangkat: String,
    val nama: String,
    val tgl_berangkat: String,
    val tgl_berangkat_induk: String
): Parcelable