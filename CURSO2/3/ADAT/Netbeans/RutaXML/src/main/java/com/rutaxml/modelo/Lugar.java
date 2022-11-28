/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rutaxml.modelo;

/**
 *
 * @author manuelconde
 */
public class Lugar {
    
    private static int cont = 0;
    private int idLugar;
    private String nombre;
    private String caracteristicas;
    
    
    public Lugar() {
        
        this.nombre = null;
        this.caracteristicas = null;
        Lugar.cont++;
        this.idLugar = Lugar.cont;
    }

    
    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    
    @Override
    public String toString() {
        return "Lugar {" + "ID = " + this.idLugar + ", nombre = " + this.nombre + ", caracteristicas = " + this.caracteristicas + '}';
    }
}