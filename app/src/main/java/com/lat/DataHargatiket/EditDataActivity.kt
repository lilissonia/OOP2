package com.lat.DataHargatiket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lat.DataHargatiket.Database.AppRoomDB
import com.lat.DataHargatiket.Database.Constant
import com.lat.DataHargatiket.Database.DataHarga
import kotlinx.android.synthetic.main.activity_edit_data.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditDataActivity : AppCompatActivity() {

    val db by lazy { AppRoomDB(this) }
    private var dataId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_data)
        setupListener()
        setupView()
    }

    fun setupListener(){
        btn_save.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.dataHargaDao().addDataHarga(
                    DataHarga(0, txt_kotaasal.text.toString(), txt_tujuan.text.toString(), Integer.parseInt(txt_harga.text.toString()) )
                )
                finish()
            }
        }
        btn_update.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.dataHargaDao().updateDataHarga(
                    DataHarga(dataId, txt_kotaasal.text.toString(), txt_tujuan.text.toString(), Integer.parseInt(txt_harga.text.toString()) )
                )
                finish()
            }
        }
    }

    fun setupView() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val intentType = intent.getIntExtra("intent_type", 0)
        when (intentType) {
            Constant.TYPE_CREATE -> {
                btn_update.visibility = View.GONE
            }
            Constant.TYPE_READ -> {
                btn_save.visibility = View.GONE
                btn_update.visibility = View.GONE
                getKaryawan()
            }
            Constant.TYPE_UPDATE -> {
                btn_save.visibility = View.GONE
                getKaryawan()
            }
        }
    }

    fun getKaryawan() {
        dataId = intent.getIntExtra("intent_id", 0)
        CoroutineScope(Dispatchers.IO).launch {
           val datas =  db.dataHargaDao().getDataHarga( dataId )[0]
            txt_kotaasal.setText( datas.kota_asal )
            txt_tujuan.setText( datas.kota_tujuan.toString() )
            txt_harga.setText( datas.harga.toString() )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}