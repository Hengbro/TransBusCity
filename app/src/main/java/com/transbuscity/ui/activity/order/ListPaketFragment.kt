package com.transbuscity.ui.activity.order

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inyongtisto.myhelper.extension.*
import com.transbuscity.ui.activity.home.HomeViewModel
import com.transbuscity.ui.base.BaseFragment
import com.transbuscity.core.source.remote.network.State
import com.transbuscity.databinding.ActivityListPaketBinding
import com.transbuscity.ui.activity.data.DataPenumpangActivity
import com.transbuscity.ui.activity.order.adapter.PaketAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListPaketFragment(
    val extra: String?,
    val onClose: () -> Unit
) : BaseFragment() {

    private var _binding: ActivityListPaketBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModel()
    private val adapter = PaketAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityListPaketBinding.inflate(layoutInflater)
        requireActivity().hidenKeyboard()

        mainButton()
        getTujuan()
        setAdapter()
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun mainButton() {
        binding.apply {
            layout.setOnClickListener {
                intentActivity(DataPenumpangActivity::class.java)
            }

        }
    }

    private fun setAdapter(){
        binding.rvTempatRek.adapter = adapter
    }

    private fun getTujuan() {
        viewModel.getJadwalTujuan().observe(requireActivity()){
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
}