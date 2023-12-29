package com.zenenta.pos.ui.base

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.inyongtisto.myhelper.util.AppProgressDialog

abstract class BaseActivity : AppCompatActivity() {
    lateinit var progress: AppProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupProgress()
    }


    private fun setupProgress() {
        progress = AppProgressDialog(this)
        progress.setCancelable(false)
        progress.setCanceledOnTouchOutside(false)
    }

    override fun onSupportNavigateUp(): Boolean {
        backPressed()
        return super.onSupportNavigateUp()
    }

    fun backPressed() {
        onBackPressedDispatcher.onBackPressed()
    }

    fun onBackPressedCall() {
        onBackPressedDispatcher.onBackPressed()
    }

    fun onBackPressedCallback(onBackPressed: (() -> Unit)? = null) {
        onBackPressed?.let {
            onBackPressedDispatcher.addCallback {
                onBackPressed.invoke()
            }
        }
    }
}