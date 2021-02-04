package com.lat.DataHargatiket.Database

import androidx.room.*

@Dao
interface DataHargaDao {
    @Insert
    suspend fun addDataHarga(dataHarga: DataHarga)

    @Update
    suspend fun updateDataHarga(dataHarga: DataHarga)

    @Delete
    suspend fun deleteDataHarga(dataHarga: DataHarga)

    @Query("SELECT * FROM dataharga")
    suspend fun getAllDataHarga(): List<DataHarga>

    @Query("SELECT * FROM dataharga WHERE id=:data_id")
    suspend fun getDataHarga(data_id: Int) : List<DataHarga>

}