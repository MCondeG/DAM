package com.example.gestionrutas.modelo.entidades;

import java.io.Serializable;


public class Posicion implements Serializable {

    private static int cont = 0;

    private int id;
    private String nombre;
    private double latitud;
    private double longitud;


    public Posicion() {

        Posicion.cont++;
        this.id = Posicion.cont;
    }

    public Posicion(String nombre, double latitud, double longitud) {

        Posicion.cont++;
        this.id = Posicion.cont;

        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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


    @Override
    public String toString() {
        return (this.nombre + " (lat: " + this.latitud + ", long: " + this.longitud + ")");
    }
}