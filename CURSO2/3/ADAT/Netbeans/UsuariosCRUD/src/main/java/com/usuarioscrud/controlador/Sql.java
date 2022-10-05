/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usuarioscrud.controlador;

/**
 *
 * @author manuelconde
 */
public class Sql {
    
    private ConexionBD conexion;
    private String sql;
    
    
    public Sql() {
        
        this.conexion = new ConexionBD("mysql", "UsuariosBD", "root", "root");
        this.sql = "";
    }
    

    public ConexionBD getConexion() {
        return conexion;
    }
    
    
    public void añadir(String nombre, String apellido, String direccion) {
        
        this.sql = "insert into usuario (nombre, apellido, direccion) values('"+nombre+"', '"+apellido+"', '"+direccion+"')";
        this.conexion.ejecutarUpdate(this.sql);
    }
}