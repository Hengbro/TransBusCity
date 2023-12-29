package com.transbuscity.ui.activity.order

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.inyongtisto.myhelper.extension.convertTanggal
import com.inyongtisto.myhelper.extension.extra
import com.inyongtisto.myhelper.extension.getStartOfTheDay
import com.inyongtisto.myhelper.extension.logs
import com.inyongtisto.myhelper.extension.toGone
import com.inyongtisto.myhelper.extension.toJson
import com.inyongtisto.myhelper.extension.toVisible
import com.inyongtisto.myhelper.extension.toastError
import com.transbuscity.R
import com.transbuscity.core.model.Result
import com.transbuscity.core.source.remote.network.State
import com.transbuscity.databinding.ActivityPemesananBinding
import com.transbuscity.databinding.ActivityPilihKursiBinding
import com.transbuscity.ui.activity.home.HomeViewModel
import com.transbuscity.ui.activity.order.adapter.PickUpAdapter
import com.transbuscity.ui.activity.order.adapter.TiketAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChoiceChairActivity :  AppCompatActivity(){

    private var _binding: ActivityPilihKursiBinding? = null

    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPilihKursiBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun mainButton(){
        binding.apply {

        }
    }
    private fun setAdapter(){

    }
}