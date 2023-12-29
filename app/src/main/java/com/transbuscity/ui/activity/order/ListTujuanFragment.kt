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
import com.transbuscity.databinding.ActivityListTujuanBinding
import com.transbuscity.ui.activity.order.adapter.TiketAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListTujuanFragment(
    val extra: String?,
    val onClose: () -> Unit
) : BaseFragment() {

    private var _binding: ActivityListTujuanBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModel()
    private val adapter = TiketAdapter()
    private var enableToEdit = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityListTujuanBinding.inflate(layoutInflater)
        requireActivity().hidenKeyboard()

        mainButton()
        getTujuan()
        setAdapter()
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun mainButton() {
        binding.apply {

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