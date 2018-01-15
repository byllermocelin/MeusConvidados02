package com.mocelin.meusconvidados02.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mocelin.meusconvidados02.constants.DataBaseConstants;

/**
 * Created by mocelin on 08/01/2018.
 */

public class GuestDataBaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "GuestDataBaseHelper";

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MeusConvidados.db";

    // Criação da tabela de categoria
    private static final String SQL_CREATE_TABLE_GUEST =
            "create table " + DataBaseConstants.GUEST.TABLE_NAME + " ("
                    + DataBaseConstants.GUEST.COLUMNS.ID + " integer primary key autoincrement, "
                    + DataBaseConstants.GUEST.COLUMNS.NAME + " text, "
                    + DataBaseConstants.GUEST.COLUMNS.PRESENCE + " integer);";

    // Remoção de tabelas
    // private static final String DROP_TABLE_GUEST = "DROP TABLE IF EXISTS " + DataBaseConstants.GUEST.TABLE_NAME;

    /**
     * Construtor padrão
     */
    public GuestDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Método executado somente uma vez quando o acesso ao banco de dados é feito pela primeira vez
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG, "onCreate: ");
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_GUEST);
        Log.e(TAG, "onCreate: nao criou banco de dados");
    }

    /**
     * Método executado quando a versão do DATABASE_VERSION é alterada
     * Dessa maneira, a aplicação sabe que o banco de dados foi alterado e é necessário rodar o script de update
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // sqLiteDatabase.execSQL(DROP_TABLE_GUEST);
        // sqLiteDatabase.execSQL(SQL_CREATE_TABLE_GUEST);
    }
}