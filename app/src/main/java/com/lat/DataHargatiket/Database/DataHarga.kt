package com.lat.DataHargatiket.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dataharga")
data class DataHarga(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "kota_asal") val kota_asal: String,
    @ColumnInfo(name = "kota_tujuan") val kota_tujuan: String,
    @ColumnInfo(name = "harga") val harga: Int
)