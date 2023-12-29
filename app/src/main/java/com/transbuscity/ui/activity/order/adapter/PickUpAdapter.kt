package com.transbuscity.ui.activity.order.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.toRupiah
import com.transbuscity.core.model.JadwalTujuan
import com.transbuscity.core.model.Result
import com.transbuscity.databinding.ItemHargaBinding
import com.transbuscity.databinding.ItemJadwalBinding
import com.transbuscity.ui.activity.order.TiketOrder

@SuppressLint("NotifyDataSetChanged")
class PickUpAdapter () : RecyclerView.Adapter<PickUpAdapter.ViewHolder>(){

    private var data = ArrayList<Result?>()

    inner class ViewHolder(private val itemBinding: ItemHargaBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(item : Result?, position: Int){
            itemBinding.apply {
                txtNametujuan.text = item?.list_outlet_pickup
                txtHarga.text = item?.tujuan?.tarif.toRupiah()
                txtJumlah.text = item?.tersedia.toString()
                val context = root.context
                layout.setOnClickListener {
                    //context.intentActivity(TiketOrder::class.java, item)
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(items: List<Result?>?){
        data.clear()
        items?.let { data.addAll(it) }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHargaBinding.inflate(
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