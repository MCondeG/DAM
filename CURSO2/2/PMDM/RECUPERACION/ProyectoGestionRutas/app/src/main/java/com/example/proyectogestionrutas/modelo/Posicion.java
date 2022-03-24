package com.example.proyectogestionrutas.modelo;

import java.io.Serializable;

public class Posicion implements Serializable {

    private double latitud;
    private double longitud;


    public Posicion() {
    }

    public Posicion(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }


    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
