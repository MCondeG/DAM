/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebajpa.ENTITY;

/**
 *
 * @author rafa
 */
public class PosicionXML {
    
    private Integer idposicion;
    private String nombrePosicion;
    private Float longitud;
    private Float latitud;
    private String descripcionP;

    public PosicionXML() {
    }

    public PosicionXML(Integer idposicion, String nombrePosicion, Float longitud, Float latitud, String descripcionP) {
        this.idposicion = idposicion;
        this.nombrePosicion = nombrePosicion;
        this.longitud = longitud;
        this.latitud = latitud;
        this.descripcionP = descripcionP;
    }

    public Integer getIdposicion() {
        return idposicion;
    }

    public void setIdposicion(Integer idposicion) {
        this.idposicion = idposicion;
    }

    public String getNombrePosicion() {
        return nombrePosicion;
    }

    public void setNombrePosicion(String nombrePosicion) {
        this.nombrePosicion = nombrePosicion;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }


     
    
}
