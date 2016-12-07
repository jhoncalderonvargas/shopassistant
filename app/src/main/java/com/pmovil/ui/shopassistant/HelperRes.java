package com.pmovil.ui.shopassistant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class HelperRes extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DB_NAME = "res.sqlite";

    public HelperRes(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(EsquemaRes.CREATE_TABLE);

        /*ContentValues values = new ContentValues();
        // Pares clave-valor
        values.put(EsquemaRes.EsqRes.ID, "1");
        values.put(EsquemaRes.EsqRes.RESPUESTA, "Hola si lo tengo, puede ofertar");
        values.put(EsquemaRes.EsqRes.CLAVES, "tiene disponible disponibilidad existencia stock");
        sqLiteDatabase.insert(EsquemaRes.EsqRes.TABLE_NAME, null, values);*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    /*
    public long saveRes(Respuestas res) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                EsquemaRes.EsqRes.TABLE_NAME,
                null,
                res.toContentValues());*/
}