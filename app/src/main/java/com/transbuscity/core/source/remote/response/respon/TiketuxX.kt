package com.transbuscity.core.source.remote.response.respon


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.transbuscity.core.model.Result


data class TiketuxX<T>(
    val result: List<T> = emptyList(),
    val status: String?,
    val time: String?
)