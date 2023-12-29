package com.transbuscity.core.repo

import com.inyongtisto.myhelper.extension.getErrorBody
import com.transbuscity.core.source.local.LocalDataSource
import com.transbuscity.core.source.remote.network.Resource
import com.transbuscity.core.source.remote.response.RemoteDataSource
import kotlinx.coroutines.flow.flow

class JadwalRepository (local: LocalDataSource, val remote: RemoteDataSource) {

    fun getJadwal() = flow {
        emit(Resource.loading(null))
        try {
            remote.getJadwal().let {
                if (it.isSuccessful) {
                    val body = it.body()
                    val data = body?.tiketux?.result
                    emit(Resource.success(data))
                } else {
                    emit(Resource.error(it.getErrorBody()?.message.orEmpty(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.orEmpty(), null))
        }
    }

    fun getJadwalAsal() = flow {
        emit(Resource.loading(null))
        try {
            remote.getJadwalAsal().let {
                if (it.isSuccessful) {
                    val body = it.body()
                    val data = body?.tiketux?.result
                    emit(Resource.success(data))
                } else {
                    emit(Resource.error(it.getErrorBody()?.message.orEmpty(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.orEmpty(), null))
        }
    }

    fun getJadwalTujuan() = flow {
        emit(Resource.loading(null))
        try {
            remote.getJadwalTujuan().let {
                if (it.isSuccessful) {
                    val body = it.body()
                    val data = body?.tiketux?.result
                    emit(Resource.success(data))
                } else {
                    emit(Resource.error(it.getErrorBody()?.message.orEmpty(), null))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(e.message.orEmpty(), null))
        }
    }
}