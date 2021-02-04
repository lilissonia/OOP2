package com.lat.DataHargatiket.Database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/lat/DataHargatiket/Database/DataHargaDao;", "", "addDataHarga", "", "dataHarga", "Lcom/lat/DataHargatiket/Database/DataHarga;", "(Lcom/lat/DataHargatiket/Database/DataHarga;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDataHarga", "getAllDataHarga", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDataHarga", "data_id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDataHarga", "app_debug"})
public abstract interface DataHargaDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert()
    public abstract java.lang.Object addDataHarga(@org.jetbrains.annotations.NotNull()
    com.lat.DataHargatiket.Database.DataHarga dataHarga, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateDataHarga(@org.jetbrains.annotations.NotNull()
    com.lat.DataHargatiket.Database.DataHarga dataHarga, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object deleteDataHarga(@org.jetbrains.annotations.NotNull()
    com.lat.DataHargatiket.Database.DataHarga dataHarga, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM dataharga")
    public abstract java.lang.Object getAllDataHarga(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.lat.DataHargatiket.Database.DataHarga>> p0);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM dataharga WHERE id=:data_id")
    public abstract java.lang.Object getDataHarga(int data_id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.lat.DataHargatiket.Database.DataHarga>> p1);
}