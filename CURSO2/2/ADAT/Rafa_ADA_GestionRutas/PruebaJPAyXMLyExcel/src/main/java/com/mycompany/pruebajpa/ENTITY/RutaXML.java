/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebajpa.ENTITY;

import java.util.ArrayList;

/**
 *
 * @author rafa
 */
public class RutaXML {
    
    private Integer idruta;
    private String nombreRuta;
    private String descripcionR; 
    private String distanciaTeorica;
    private String velocidadTeorica; 
    private String tiempoTeorico;
    private String distanciaReal;
    private String velocidadReal;
    private String tiempoReal;
    private String rumbo;
    private ArrayList<TramoXML> tramo;

    public RutaXML() {
    }

    public RutaXML(Integer idruta, String nombreRuta,String descripcionR, String distanciaTeorica, String velocidadTeorica, String tiempoTeorico, String distanciaReal, String velocidadReal, String tiempoReal, String rumbo) {
        this.idruta = idruta;
        this.nombreRuta= nombreRuta;
        this.descripcionR = descripcionR;
        this.distanciaTeorica = distanciaTeorica;
        this.velocidadTeorica = velocidadTeorica;
        this.tiempoTeorico = tiempoTeorico;
        this.distanciaReal = distanciaReal;
        this.velocidadReal = velocidadReal;
        this.tiempoReal = tiempoReal;
        this.rumbo = rumbo;
    }

    public Integer getIdruta() {
        return idruta;
    }

    public void setIdruta(Integer idruta) {
        this.idruta = idruta;
    }

    public String getDescripcionR() {
        return descripcionR;
    }

    public void setDescripcionR(String descripcionP) {
        this.descripcionR = descripcionP;
    }

    public String getDistanciaTeorica() {
        return distanciaTeorica;
    }

    public void setDistanciaTeorica(String distanciaTeorica) {
        this.distanciaTeorica = distanciaTeorica;
    }

    public String getVelocidadTeorica() {
        return velocidadTeorica;
    }

    public void setVelocidadTeorica(String velocidadTeorica) {
        this.velocidadTeorica = velocidadTeorica;
    }

    public String getTiempoTeorico() {
        return tiempoTeorico;
    }

    public void setTiempoTeorico(String tiempoTeorico) {
        this.tiempoTeorico = tiempoTeorico;
    }

    public String getDistanciaReal() {
        return distanciaReal;
    }

    public void setDistanciaReal(String distanciaReal) {
        this.distanciaReal = distanciaReal;
    }

    public String getVelocidadReal() {
        return velocidadReal;
    }

    public void setVelocidadReal(String velocidadReal) {
        this.velocidadReal = velocidadReal;
    }

    public String getTiempoReal() {
        return tiempoReal;
    }

    public void setTiempoReal(String tiempoReal) {
        this.tiempoReal = tiempoReal;
    }

    public String getRumbo() {
        return rumbo;
    }

    public void setRumbo(String rumbo) {
        this.rumbo = rumbo;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public ArrayList<TramoXML> getTramo() {
        return tramo;
    }

    public void setTramo(ArrayList<TramoXML> tramo) {
        this.tramo = tramo;
    }

   

    
}
