package com.example.gestionrutas.modelo.entidades;

import java.util.ArrayList;

public class Ruta {

    private ArrayList<Tramo> tramos;

    private String descripcion;

    private double distanciaT;
    private double tiempoT;
    private double velocidadT;

    private double distanciaR;
    private double tiempoR;
    private double velocidadR;


    public Ruta() {

    }

    public Ruta(ArrayList<Tramo> tramos) {
        this.tramos = tramos;
    }


    public ArrayList<Tramo> getTramos() {
        return tramos;
    }

    public void setTramos(ArrayList<Tramo> tramos) {
        this.tramos = tramos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDistanciaT() {
        return distanciaT;
    }

    public void setDistanciaT(double distanciaT) {
        this.distanciaT = distanciaT;
    }

    public double getTiempoT() {
        return tiempoT;
    }

    public void setTiempoT(double tiempoT) {
        this.tiempoT = tiempoT;
    }

    public double getVelocidadT() {
        return velocidadT;
    }

    public void setVelocidadT(double velocidadT) {
        this.velocidadT = velocidadT;
    }

    public double getDistanciaR() {
        return distanciaR;
    }

    public void setDistanciaR(double distanciaR) {
        this.distanciaR = distanciaR;
    }

    public double getTiempoR() {
        return tiempoR;
    }

    public void setTiempoR(double tiempoR) {
        this.tiempoR = tiempoR;
    }

    public double getVelocidadR() {
        return velocidadR;
    }

    public void setVelocidadR(double velocidadR) {
        this.velocidadR = velocidadR;
    }
}