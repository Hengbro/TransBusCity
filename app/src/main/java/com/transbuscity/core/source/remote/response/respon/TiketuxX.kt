package com.transbuscity.core.source.remote.response.respon


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.transbuscity.core.model.Result

@Parcelize
data class TiketuxX(
    val result: List<Result?>?,
    val status: String?,
    val time: String?
) : Parcelable