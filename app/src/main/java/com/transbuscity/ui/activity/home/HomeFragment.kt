package com.transbuscity.ui.activity.home

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.inyongtisto.myhelper.extension.convertTanggal
import com.inyongtisto.myhelper.extension.getStartOfTheDay
import com.transbuscity.core.source.remote.network.State
import com.inyongtisto.myhelper.extension.toGone
import com.inyongtisto.myhelper.extension.toVisible
import com.inyongtisto.myhelper.extension.toastError
import com.transbuscity.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.transbuscity.databinding.FragmentHomeBinding
import com.transbuscity.ui.base.BaseFragment
import com.transbuscity.ui.activity.home.adapter.HomeAdapter
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class HomeFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private val adapterJadwal = HomeAdapter()
    private val viewModel: HomeViewModel by viewModel()
    private var startDate: String? = getStartOfTheDay()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        mainButton()
        setUpAdapter()
        getData()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun mainButton(){
        binding.apply {
            val textStartDate = startDate?.convertTanggal("dd MMM yyyy")
            today.text = textStartDate
        }
    }

    private fun setUpAdapter(){
        binding.rvJadwal.adapter = adapterJadwal
    }

    private fun getData(){
        viewModel.getJadwal().observe(requireActivity()){
            when (it.state) {
                State.SUCCESS -> {
                    binding.pdJadwal.toGone()
                    val data = it.result
                    adapterJadwal.addItems(data)
                }
                State.ERROR -> {
                    binding.pdJadwal.toGone()
                    toastError(it?.message ?: "Error")
                }
                State.LOADING -> {
                    binding.pdJadwal.toVisible()
                }
            }
        }
    }

}