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
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.logs
import com.inyongtisto.myhelper.extension.toGone
import com.inyongtisto.myhelper.extension.toJson
import com.inyongtisto.myhelper.extension.toVisible
import com.inyongtisto.myhelper.extension.toastError
import com.transbuscity.R
import com.transbuscity.core.model.Result
import com.transbuscity.core.source.remote.network.State
import com.transbuscity.databinding.ActivityPemesananBinding
import com.transbuscity.ui.activity.home.HomeViewModel
import com.transbuscity.ui.activity.order.adapter.PickUpAdapter
import com.transbuscity.ui.activity.order.adapter.TiketAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class TiketOrder :  AppCompatActivity(){

    private var _binding: ActivityPemesananBinding? = null
    private var startDate: String? = getStartOfTheDay()
    private val tujuan by extra<Result>()
    private val viewModel: HomeViewModel by viewModel()
    private val adapter = PickUpAdapter()
    private val fm: FragmentManager = supportFragmentManager
    private val fragmentTiket: ListTujuanFragment = ListTujuanFragment(null) {

    }

    private val fragmentPaket: ListPaketFragment = ListPaketFragment(null) {

    }

    private var active: Fragment = fragmentTiket

    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPemesananBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainButton()
        setData()
        getDataList()
        mainButton()
        setAdapter()
        setupNavigation()
    }

    private fun mainButton(){
        binding.apply {
            btnBack.setOnClickListener{
                onBackPressed()
            }
            val textStartDate = startDate?.convertTanggal("dd MMM yyyy")
            today.text = textStartDate

            btnTiket.setOnClickListener {
                setMenu(btnTiket)
            }

            btnPaket.setOnClickListener {
                setMenu(btnPaket)
            }

            btnManifest.setOnClickListener {
                setMenu(btnManifest)
            }

            mainFrame.setOnClickListener {
                intentActivity(ChoiceChairActivity::class.java)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setData(){
        binding.apply {
            tujuan?.let {
                logs("Movie:" +it.toJson())
                txtJam.text = it.jam
                tvJam.text = it.jam
                tvJam.text = it.jam
                tvAsalkotapaket.text = it.rute
                tvAsalkota.text = it.kode_jadwal
                txtRute.text = it.rute
                typeDetailRute.text = it.detail_rute +" / "+it.layanan
                typeTransit.text = it.list_outlet_transit
            }
        }
    }
    private fun setAdapter(){
        binding.rvTempatRek.adapter = adapter
    }

    private fun getDataList() {
        viewModel.getJadwal().observe(this){
            when (it.state) {
                State.SUCCESS -> {
                    binding.progress.toGone()
                    val data = it.result
                    adapter.addItems(data)
                }
                State.ERROR -> {
                    binding.progress.toGone()
                    toastError(it?.message ?: "Error")
                }
                State.LOADING -> {
                    binding.progress.toVisible()
                }
            }
        }
    }

    private fun setMenu(view: TextView) {
        val listMenu = listOf(
            binding.btnTiket, binding.btnPaket, binding.btnManifest
        )
        binding.apply {
            listMenu.forEach { btn ->
                if (btn == view) {
                    btn.setBackgroundColor(getColor(R.color.colorPrimary))
                    btn.setTextColor(getColor(R.color.white))
                } else {
                    btn.setBackgroundColor(getColor(R.color.white))
                    btn.setTextColor(getColor(R.color.gray3))
                }
            }

            when (view) {
                btnTiket -> {
                    callFragment(fragmentTiket)
                }

                btnPaket -> {
                    callFragment(fragmentPaket)
                }

                btnManifest -> {
                    callFragment(fragmentTiket)

                }
            }
        }
    }

    private fun setupNavigation() {
        val container = binding.mainFrame.id
        fm.beginTransaction().add(container, fragmentTiket).show(fragmentTiket).commit()
        fm.beginTransaction().add(container, fragmentPaket).hide(fragmentPaket).commit()

    }

    private fun callFragment(fragment: Fragment) {
        fm.beginTransaction().apply {
            hide(active)
            show(fragment)
            active = fragment
            commit()
        }
    }
}