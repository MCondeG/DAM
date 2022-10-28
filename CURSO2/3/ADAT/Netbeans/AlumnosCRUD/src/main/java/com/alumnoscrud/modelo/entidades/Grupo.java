/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alumnoscrud.modelo.entidades;

/**
 *
 * @author manuelconde
 */
public class Grupo {
    
    private int id_grupo;
    private String nombre;
    private String observaciones;
    
    
    public Grupo() {
        
        this.id_grupo = 0;
        this.nombre = "";
        this.observaciones = "";
    }
    
    public Grupo(int id, String nombre, String observaciones) {
        this.id_grupo = id;
        this.nombre = nombre;
        this.observaciones = observaciones;
    }

    
    public int getId_grupo() {
        return id_grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}