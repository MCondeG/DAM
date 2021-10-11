/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manuelcondegonzalez.semanacultural.modelo.entidades;

/**
 *
 * @author manuelconde
 */
public class Profesor {
    
    private int id_profesor;
    private String nombre;
    private String usuario;
    private String contraseña;
    
    
    public Profesor() {
        
    }
    
    public Profesor(int id_profesor, String nombre, String usuario, String contraseña) {
        
        this.id_profesor = id_profesor;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    
    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}