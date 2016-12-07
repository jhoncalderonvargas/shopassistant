package com.pmovil.ui.shopassistant;

import android.provider.BaseColumns;

import java.sql.Array;

/**
 * Created by JAC on 07/12/2016.
 */

public class EsquemaRes {
    public static abstract class EsqRes implements BaseColumns {
        public static final String TABLE_NAME = "Respuestas automaticas";
        public static final String ID = "id";
        public static final String RESPUESTA= "res";
        public static final String CLAVES = "claves";

    }
}
