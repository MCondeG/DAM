/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usuarioscrud.modelo;

/**
 *
 * @author manuelconde
 */
public class Usuario {
    
    private String nombre;
    private String apellido;
    private String direccion;
    
    
    public Usuario() {
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
    }
    
    public Usuario(String nombre, String apellido, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Override
    public String toString() {
        return (this.nombre + " " + this.apellido + ", " + this.direccion);
    }
}