package com.transbuscity.ui.activity.order

import android.annotation.SuppressLint
import android.os.Bundle
import com.inyongtisto.myhelper.extension.*
import com.transbuscity.databinding.ActivityFragmentBinding
import com.zenenta.pos.ui.base.BaseActivity

@SuppressLint("CustomSplashScreen")
class ListPaketActivity : BaseActivity() {
    private var _binding: ActivityFragmentBinding? = null
    private val binding get() = _binding!!
    private val extra by extra<String>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = ListPaketFragment(extra){
            finish()
        }
        supportFragmentManager.beginTransaction()
            .replace(binding.containerTable.id, fragment)
            .commit()
    }
}