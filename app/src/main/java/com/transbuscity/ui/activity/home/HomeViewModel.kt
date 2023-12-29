package com.transbuscity.ui.activity.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.transbuscity.core.repo.JadwalRepository

class HomeViewModel (private val repository: JadwalRepository) : ViewModel() {

    fun getJadwal() = repository.getJadwal().asLiveData()
    fun getJadwalAsal() = repository.getJadwalAsal().asLiveData()
    fun getJadwalTujuan() = repository.getJadwalTujuan().asLiveData()

}