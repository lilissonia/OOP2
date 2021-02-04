package com.lat.DataHargatiket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager

import com.lat.DataHargatiket.Database.AppRoomDB
import com.lat.DataHargatiket.Database.Constant
import com.lat.DataHargatiket.Database.DataHarga
import kotlinx.android.synthetic.main.activity_data.*
import kotlinx.android.synthetic.main.activity_data.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DataActivity : AppCompatActivity() {

    val db by lazy { AppRoomDB(this) }
    lateinit var dataAdapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        setupListener()
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    fun loadData(){
        CoroutineScope(Dispatchers.IO).launch {
            val allDataHarga = db.dataHargaDao().getAllDataHarga()
            Log.d("DataActivity", "dbResponse: $allDataHarga")
            withContext(Dispatchers.Main) {
                dataAdapter.setData(allDataHarga)
            }
        }
    }

    fun setupListener() {
        btn_createData.setOnClickListener {
           intentEdit(0, Constant.TYPE_CREATE)
        }
    }

    fun setupRecyclerView() {
        dataAdapter = DataAdapter(arrayListOf(), object: DataAdapter.OnAdapterListener {
            override fun onClick(dataHarga: DataHarga) {
                // read detail
                intentEdit(dataHarga.id, Constant.TYPE_READ)
            }

            override fun onDelete(dataHarga: DataHarga) {
                // delete data
                deleteDialog(dataHarga)
            }

            override fun onUpdate(dataHarga: DataHarga) {
                // edit data
                intentEdit(dataHarga.id, Constant.TYPE_UPDATE)
            }

        })
        list_data.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = dataAdapter
        }
    }

    fun intentEdit(dataId: Int, intentType: Int ) {
        startActivity(
            Intent(applicationContext, EditDataActivity::class.java)
                .putExtra("intent_id", dataId)
                .putExtra("intent_type", intentType)
        )
    }

    private fun deleteDialog(dataHarga: DataHarga) {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setTitle("Konfirmasi")
            setMessage("Yakin ingin menghapus data ini?")
            setNegativeButton("Batal") { dialogInterface, i ->
                dialogInterface.dismiss()
            }
            setPositiveButton("Hapus") { dialogInterface, i ->
                dialogInterface.dismiss()
                CoroutineScope(Dispatchers.IO).launch {
                    db.dataHargaDao().deleteDataHarga(dataHarga)
                    loadData()
                }
            }
        }
        alertDialog.show()
    }
}