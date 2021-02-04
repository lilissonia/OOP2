package com.lat.DataHargatiket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.lat.DataHargatiket.Database.DataHarga
import kotlinx.android.synthetic.main.adapter_data.view.*
import kotlinx.android.synthetic.main.adapter_data.view.*

class DataAdapter (private val allDataHarga: ArrayList<DataHarga>, private val listener: OnAdapterListener) : RecyclerView.Adapter<DataAdapter.DataHargaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHargaViewHolder {
        return DataHargaViewHolder(
            LayoutInflater.from(parent.context).inflate( R.layout.adapter_data, parent, false)
        )
    }

    override fun getItemCount() = allDataHarga.size

    override fun onBindViewHolder(holder: DataHargaViewHolder, position: Int) {
        val DataHarga = allDataHarga[position]
        holder.view.text_data.text = DataHarga.kota_asal
        holder.view.text_data.setOnClickListener {
            listener.onClick(DataHarga)
        }
        holder.view.icon_delete.setOnClickListener {
            listener.onDelete(DataHarga)
        }
        holder.view.icon_edit.setOnClickListener {
            listener.onUpdate(DataHarga)
        }
    }

    class DataHargaViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(list: List<DataHarga>) {
        allDataHarga.clear()
        allDataHarga.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(dataHarga: DataHarga)
        fun onDelete(dataHarga: DataHarga)
        fun onUpdate(dataHarga: DataHarga)
    }
}