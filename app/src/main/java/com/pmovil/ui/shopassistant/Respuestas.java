package com.pmovil.ui.shopassistant;

public class Respuestas {
    public String claves[]= new String[4];
    public long id;
    public Respuestas(){
        super();
    }
    public Respuestas(String res,String compara1,String compara2, String compara3){
        super();
        this.claves[0]=res;
        this.claves[1]=compara1;
        this.claves[2]=compara2;
        this.claves[3]=compara3;
    }

    public String getRespuesta(){
        return this.claves[0];
    }

    public String getComparacion(int i){
        return this.claves[i];
    }

    public void setRespuesta(String Respuestas){
        this.claves[0]=Respuestas;
    }

    public void setComparacion(int i,String Comparacion){
        this.claves[i]=Comparacion;
    }
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }
}
