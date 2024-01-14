package com.example.registroactividadesfisicas;

public class Lugares  {
    String km;
    String nombre;
   int  tipoLugar;
    public Lugares(String km, String nombre,int tipoLugar){
        this.km = km;
        this.nombre = nombre;
        this.tipoLugar = tipoLugar;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getKm() {
        return km;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTipoLugar() {
        return tipoLugar;
    }

    public void setTipoLugar(int tipoLugar) {
        this.tipoLugar = tipoLugar;
    }
}