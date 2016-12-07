package com.pmovil.ui.shopassistant;

import android.provider.BaseColumns;

import java.sql.Array;

/**
 * Created by JAC on 07/12/2016.
 */

public class EsquemaRes {
        public static final String TABLE_NAME = "res";

        public static final String CN_ID = "_id";
        public static final String CN_RESPUESTA= "res";
        public static final String CN_CLAVES = "claves";
        public static final String CREATE_TABLE = "create table " + TABLE_NAME + " ("
                + CN_ID + " integer primary key autoincrement,"
                + CN_RESPUESTA + " text not null,"
                + CN_CLAVES + " text not null);";
}
