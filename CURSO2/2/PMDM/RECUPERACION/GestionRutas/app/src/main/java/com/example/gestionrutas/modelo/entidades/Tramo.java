package com.example.gestionrutas.modelo.entidades;


import java.io.Serializable;


public class Tramo implements Serializable {

    private Posicion pos1;
    private Posicion pos2;

    private double distanciaT;
    private double tiempoT;
    private double velocidadT;

    private double distanciaR;
    private double tiempoR;
    private double velocidadR;


    public Tramo() {

    }

    public Tramo(Posicion pos1, Posicion pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;

        final double cateto1 = (pos2.getLatitud() - pos1.getLatitud());
        final double cateto2 = (pos2.getLongitud() - pos1.getLongitud());
        this.distanciaT = Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
    }


    public Posicion getPos1() {
        return pos1;
    }

    public void setPos1(Posicion pos1) {
        this.pos1 = pos1;
    }

    public Posicion getPos2() {
        return pos2;
    }

    public void setPos2(Posicion pos2) {
        this.pos2 = pos2;
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