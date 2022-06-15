package com.example.rutas.Retrofit.EntidadesRetrofit;

public class PosicionRetroFit {


    private int idposicion;
    private Float longitud;
    private Float latitud;
    private String descripcion;


    public PosicionRetroFit() {
    }

    public int getIdposicion() {
        return idposicion;
    }

    public void setIdposicion(int idposicion) {
        this.idposicion = idposicion;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
