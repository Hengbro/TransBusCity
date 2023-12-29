package com.transbuscity.ui.activity.order.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.toGone
import com.inyongtisto.myhelper.extension.toRupiah
import com.transbuscity.core.model.JadwalTujuan
import com.transbuscity.core.model.Result
import com.transbuscity.databinding.ItemHargaBinding
import com.transbuscity.databinding.ItemJadwalBinding
import com.transbuscity.databinding.ItemPaketBinding
import com.transbuscity.ui.activity.order.TiketOrder

@SuppressLint("NotifyDataSetChanged")
class PaketAdapter () : RecyclerView.Adapter<PaketAdapter.ViewHolder>(){

    private var data = ArrayList<JadwalTujuan?>()

    inner class ViewHolder(private val itemBinding: ItemPaketBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(item : JadwalTujuan?, position: Int){
            itemBinding.apply {
                txtNametujuan.text = item?.rute
                txtJumlah.text = item?.kapasitas.toString()

                val context = root.context
                layout.setOnClickListener {
                    //context.intentActivity(TiketOrder::class.java, item)
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(items: List<JadwalTujuan?>?){
        data.clear()
        items?.let { data.addAll(it) }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPaketBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        data[position]?.let { holder.bind(it, position) }
    }

    override fun getItemCount(): Int {
        return data.size
    }
    }