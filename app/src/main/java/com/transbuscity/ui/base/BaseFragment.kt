package com.transbuscity.ui.base

import android.content.Intent
import android.os.Bundle
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.inyongtisto.myhelper.util.AppProgressDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseFragment : Fragment() {

    lateinit var progress: AppProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupProgress()
    }
    fun backPressed() {
        requireActivity().onBackPressedDispatcher.onBackPressed()
    }

    fun onBackPressedCall() {
        requireActivity().onBackPressedDispatcher.onBackPressed()
    }

    fun onBackPressedCallback(onBackPressed: (() -> Unit)? = null) {
        onBackPressed?.let {
            requireActivity().onBackPressedDispatcher.addCallback {
                onBackPressed.invoke()
            }
        }
    }

    private fun setupProgress() {
        progress = AppProgressDialog(requireActivity())
        progress.setCancelable(false)
        progress.setCanceledOnTouchOutside(false)
    }

}