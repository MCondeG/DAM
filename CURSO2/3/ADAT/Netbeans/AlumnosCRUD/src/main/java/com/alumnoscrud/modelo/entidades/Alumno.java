/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alumnoscrud.modelo.entidades;

/**
 *
 * @author manuelconde
 */
public class Alumno {
    
    private int id_alumno;
    private String nombre;
    private String observaciones;
    
    private Grupo grupo;
    
    
    public Alumno() {
        
        this.nombre = "";
        this.observaciones = "";
        this.grupo = null;
    }
    
    public Alumno(String nombre, String observaciones, Grupo grupo) {
        
        this.nombre = nombre;
        this.observaciones = observaciones;
        this.grupo = grupo;
    }

    
    public int getId_alumno() {
        return id_alumno;
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

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}