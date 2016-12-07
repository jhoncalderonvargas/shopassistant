package com.pmovil.ui.shopassistant;

import android.content.ContentValues;
import android.text.TextUtils;

public class Respuestas {
    public String claves[], respuesta, id;

    public Respuestas() {
        super();
    }

    public Respuestas(String res, String compara[]) {
        super();
        this.respuesta=res;
        this.claves = compara;
    }

    public String getRespuesta() {
        return this.respuesta;
    }

    public String[] getComparacion() {
        return this.claves;
    }

    public void setRespuesta(String Respuestas) {
        this.respuesta = Respuestas;
    }

    public void setComparacion(String Compara[]) {
        this.claves = Compara;
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