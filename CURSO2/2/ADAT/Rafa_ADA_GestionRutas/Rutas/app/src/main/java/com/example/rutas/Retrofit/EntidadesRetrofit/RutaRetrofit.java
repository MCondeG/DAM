package com.example.rutas.Retrofit.EntidadesRetrofit;

public class RutaRetrofit {

    private int idruta;
    private Float distancia_real;
    private Float velocidad_real;
    private String descripcion;
    private int  idtramoF;

    public RutaRetrofit() {
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
}
