package com.lat.DataHargatiket.Database;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DataHargaDao_Impl implements DataHargaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DataHarga> __insertionAdapterOfDataHarga;

  private final EntityDeletionOrUpdateAdapter<DataHarga> __deletionAdapterOfDataHarga;

  private final EntityDeletionOrUpdateAdapter<DataHarga> __updateAdapterOfDataHarga;

  public DataHargaDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDataHarga = new EntityInsertionAdapter<DataHarga>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `dataharga` (`id`,`kota_asal`,`kota_tujuan`,`harga`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DataHarga value) {
        stmt.bindLong(1, value.getId());
        if (value.getKota_asal() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getKota_asal());
        }
        if (value.getKota_tujuan() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getKota_tujuan());
        }
        stmt.bindLong(4, value.getHarga());
      }
    };
    this.__deletionAdapterOfDataHarga = new EntityDeletionOrUpdateAdapter<DataHarga>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `dataharga` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DataHarga value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfDataHarga = new EntityDeletionOrUpdateAdapter<DataHarga>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `dataharga` SET `id` = ?,`kota_asal` = ?,`kota_tujuan` = ?,`harga` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DataHarga value) {
        stmt.bindLong(1, value.getId());
        if (value.getKota_asal() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getKota_asal());
        }
        if (value.getKota_tujuan() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getKota_tujuan());
        }
        stmt.bindLong(4, value.getHarga());
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public Object addDataHarga(final DataHarga dataHarga, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfDataHarga.insert(dataHarga);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteDataHarga(final DataHarga dataHarga, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfDataHarga.handle(dataHarga);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object updateDataHarga(final DataHarga dataHarga, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfDataHarga.handle(dataHarga);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object getAllDataHarga(final Continuation<? super List<DataHarga>> p0) {
    final String _sql = "SELECT * FROM dataharga";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<DataHarga>>() {
      @Override
      public List<DataHarga> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfKotaAsal = CursorUtil.getColumnIndexOrThrow(_cursor, "kota_asal");
          final int _cursorIndexOfKotaTujuan = CursorUtil.getColumnIndexOrThrow(_cursor, "kota_tujuan");
          final int _cursorIndexOfHarga = CursorUtil.getColumnIndexOrThrow(_cursor, "harga");
          final List<DataHarga> _result = new ArrayList<DataHarga>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DataHarga _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpKota_asal;
            _tmpKota_asal = _cursor.getString(_cursorIndexOfKotaAsal);
            final String _tmpKota_tujuan;
            _tmpKota_tujuan = _cursor.getString(_cursorIndexOfKotaTujuan);
            final int _tmpHarga;
            _tmpHarga = _cursor.getInt(_cursorIndexOfHarga);
            _item = new DataHarga(_tmpId,_tmpKota_asal,_tmpKota_tujuan,_tmpHarga);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }

  @Override
  public Object getDataHarga(final int data_id, final Continuation<? super List<DataHarga>> p1) {
    final String _sql = "SELECT * FROM dataharga WHERE id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, data_id);
    return CoroutinesRoom.execute(__db, false, new Callable<List<DataHarga>>() {
      @Override
      public List<DataHarga> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfKotaAsal = CursorUtil.getColumnIndexOrThrow(_cursor, "kota_asal");
          final int _cursorIndexOfKotaTujuan = CursorUtil.getColumnIndexOrThrow(_cursor, "kota_tujuan");
          final int _cursorIndexOfHarga = CursorUtil.getColumnIndexOrThrow(_cursor, "harga");
          final List<DataHarga> _result = new ArrayList<DataHarga>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DataHarga _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpKota_asal;
            _tmpKota_asal = _cursor.getString(_cursorIndexOfKotaAsal);
            final String _tmpKota_tujuan;
            _tmpKota_tujuan = _cursor.getString(_cursorIndexOfKotaTujuan);
            final int _tmpHarga;
            _tmpHarga = _cursor.getInt(_cursorIndexOfHarga);
            _item = new DataHarga(_tmpId,_tmpKota_asal,_tmpKota_tujuan,_tmpHarga);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p1);
  }
}
