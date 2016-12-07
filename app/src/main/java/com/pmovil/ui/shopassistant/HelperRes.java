package com.pmovil.ui.shopassistant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.id;

public class HelperRes extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "res.db";

    public HelperRes(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + EsquemaRes.EsqRes.TABLE_NAME + " ("
                + EsquemaRes.EsqRes.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + EsquemaRes.EsqRes.RESPUESTA + " TEXT NOT NULL,"
                + EsquemaRes.EsqRes.CLAVES + " TEXT NOT NULL,"
                + "UNIQUE (" + EsquemaRes.EsqRes.ID + "))");
        ContentValues values = new ContentValues();

        // Pares clave-valor
        values.put(EsquemaRes.EsqRes.ID, "1");
        values.put(EsquemaRes.EsqRes.RESPUESTA, "Hola si lo tengo, puede ofertar");
        values.put(EsquemaRes.EsqRes.CLAVES, "tiene disponible disponibilidad");
        sqLiteDatabase.insert(EsquemaRes.EsqRes.TABLE_NAME, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long saveRes(Respuestas res) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                EsquemaRes.EsqRes.TABLE_NAME,
                null,
                res.toContentValues());

    }
}