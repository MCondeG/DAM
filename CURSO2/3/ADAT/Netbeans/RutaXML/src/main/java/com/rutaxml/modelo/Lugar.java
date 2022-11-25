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
    
    private static int idLugar = 0;
    private String nombre;
    private String caracteristicas;
    
    
    public Lugar() {
        
        this.nombre = null;
        this.caracteristicas = null;
        Lugar.idLugar++;
    }

    
    public static int getIdLugar() {
        return idLugar;
    }

    public static void setIdLugar(int idLugar) {
        Lugar.idLugar = idLugar;
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
}