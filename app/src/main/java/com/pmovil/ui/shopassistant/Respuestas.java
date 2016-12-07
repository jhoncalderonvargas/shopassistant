package com.pmovil.ui.shopassistant;

import android.content.ContentValues;
import android.text.TextUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Respuestas {
    public String claves[] = new String[4], id;

    public Respuestas() {
        super();
    }

    public Respuestas(String res, String compara1, String compara2, String compara3) {
        super();
        this.claves[0] = res;
        this.claves[1] = compara1;
        this.claves[2] = compara2;
        this.claves[3] = compara3;
    }

    public String getRespuesta() {
        return this.claves[0];
    }

    public String getComparacion(int i) {
        return this.claves[i];
    }

    public void setRespuesta(String Respuestas) {
        this.claves[0] = Respuestas;
    }

    public void setComparacion(int i, String Comparacion) {
        this.claves[i] = Comparacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        String ARRAY_DIVIDER = " ";
        values.put(EsquemaRes.EsqRes.ID, id);
        values.put(EsquemaRes.EsqRes.RESPUESTA, claves[0]);
        values.put(EsquemaRes.EsqRes.RESPUESTA, TextUtils.join(ARRAY_DIVIDER, claves));
        return values;
    }
}