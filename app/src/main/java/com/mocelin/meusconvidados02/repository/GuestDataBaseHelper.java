package com.mocelin.meusconvidados02.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mocelin.meusconvidados02.constants.DataBaseConstants;

/**
 * Created by mocelin on 08/01/2018.
 */

public class GuestDataBaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "GuestDataBaseHelper";

    private static final String DATABASE_NAME = "MeusConvidados.db";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE_GUEST =
            "create table " + DataBaseConstants.GUEST.TABLE_NAME + " ("
                    + DataBaseConstants.GUEST.COLUMNS.ID + " integer primary key autoincrement, "
                    + DataBaseConstants.GUEST.COLUMNS.NAME + " text, "
                    + DataBaseConstants.GUEST.COLUMNS.PRESENCE + " integer);";

    private static final String DROP_TABLE_GUEST = "DROP TABLE IF EXISTS " + DataBaseConstants.GUEST.TABLE_NAME;

    public GuestDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_GUEST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL(DROP_TABLE_GUEST);
        //db.execSQL(SQL_CREATE_TABLE_GUEST);
    }
}
