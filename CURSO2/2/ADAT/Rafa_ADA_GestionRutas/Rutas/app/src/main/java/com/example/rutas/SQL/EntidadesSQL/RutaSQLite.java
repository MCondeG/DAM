package com.example.rutas.SQL.EntidadesSQL;

public class RutaSQLite {

    private int idruta;
    private Float distancia_real;
    private Float velocidad_real;
    private String descripcion;
    private int  idtramoF;

    public RutaSQLite() {
    }

    public RutaSQLite(Float distancia_real, Float velocidad_real, String descripcion,int  idtramoF) {
        this.distancia_real = distancia_real;
        this.velocidad_real = velocidad_real;
        this.descripcion = descripcion;
        this.idtramoF = idtramoF;
    }

    public int getIdruta() {
        return idruta;
    }

    public void setIdruta(int idruta) {
        this.idruta = idruta;
    }

    public Float getDistancia_real() {
        return distancia_real;
    }

    public void setDistancia_real(Float distancia_real) {
        this.distancia_real = distancia_real;
    }

    public Float getVelocidad_real() {
        return velocidad_real;
    }

    public void setVelocidad_real(Float velocidad_real) {
        this.velocidad_real = velocidad_real;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdtramoF() {
        return idtramoF;
    }

    public void setIdtramoF(int idtramoF) {
        this.idtramoF = idtramoF;
    }

    @Override
    public String toString() {
        return "RutaSQLite{" +
                "idruta=" + idruta +
                ", distancia_real=" + distancia_real +
                ", velocidad_real=" + velocidad_real +
                ", descripcion='" + descripcion + '\'' +
                ", idtramoF=" + idtramoF +
                '}';
    }
}
