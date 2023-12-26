package com.transbuscity.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.transbuscity.core.model.Result
import com.transbuscity.databinding.ItemJadwalBinding

@SuppressLint("NotifyDataSetChanged")
class HomeAdapter () : RecyclerView.Adapter<HomeAdapter.ViewHolder>(){

    private var data = ArrayList<Result?>()

    inner class ViewHolder(private val itemBinding: ItemJadwalBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(item : Result?, position: Int){
            itemBinding.apply {
                txtJam.text = item?.jam
                txtKotaasal.text = item?.rute
                typeTempatddk.text = item?.layanan
                val context = root.context
                layout.setOnClickListener {

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
        return ViewHolder(ItemJadwalBinding.inflate(
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