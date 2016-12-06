package com.pmovil.ui.shopassistant;

import android.media.Image;
import android.media.ThumbnailUtils;

/**
 * Created by JAC on 06/12/2016.
 */

public class Articulos {
    String name,unidades, clave;

    public Articulos(){super();}

    public Articulos(String name, String uni, String clave)
    {
        this.name=name;
        this.unidades=uni;
        this.clave=clave;
    }
    public void setName (String name){
        this.name=name;
    }
    public void setClave (String clave){
        this.clave=clave;
    }
    public void setUnidades(String unidades){
        this.unidades=unidades;
    }
    public String getName (){
        return this.name;
    }
    public String getClave (){
        return this.clave;
    }
    public String getUnidades (){
        return this.unidades;
    }
}
