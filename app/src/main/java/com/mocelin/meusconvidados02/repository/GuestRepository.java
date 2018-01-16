package com.mocelin.meusconvidados02.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mocelin.meusconvidados02.constants.DataBaseConstants;
import com.mocelin.meusconvidados02.entities.GuestEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mocelin on 08/01/2018.
 */

public class GuestRepository {

    private static GuestRepository INSTANCE;
    private GuestDataBaseHelper mGuestDataBaseHelper;

    private GuestRepository(Context context) {
        this.mGuestDataBaseHelper = new GuestDataBaseHelper(context);
    }

    public static synchronized GuestRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new GuestRepository(context);
        }
        return INSTANCE;
    }

    /**
     * Carrega todos os convidados
     */
    public List<GuestEntity> getGuestsByQuery(String query) {
        List<GuestEntity> list = new ArrayList<>();

        try {

            SQLiteDatabase sqLiteDatabase = this.mGuestDataBaseHelper.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(query, null);

            if (cursor != null && cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    GuestEntity guestEntity = new GuestEntity();
                    guestEntity.setId(cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID)));
                    guestEntity.setName(cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME)));
                    guestEntity.setConfirmed(cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE)));

                    list.add(guestEntity);
                }
            }

            if (cursor != null) {
                cursor.close();
            }

        } catch (Exception e) {
            return list;
        }

        return list;
    }

    public Boolean insert(GuestEntity guestEntity) {
        try {

            // Para fazer escrita de dados
            SQLiteDatabase db = this.mGuestDataBaseHelper.getWritableDatabase();

            ContentValues insertValues = new ContentValues();
            insertValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guestEntity.getName());
            insertValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guestEntity.getConfirmed());
            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, insertValues);

            // Registro inserido
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
