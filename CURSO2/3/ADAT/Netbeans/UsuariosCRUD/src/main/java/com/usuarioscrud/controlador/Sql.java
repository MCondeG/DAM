/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usuarioscrud.controlador;

/**
 *
 * @author manuelconde
 */
public abstract class Sql {
    
    private static final ConexionBD conexion = new ConexionBD("mysql", "UsuariosBD", "root", "root");
    private static String sql = "";
    
    
    public static void añadir(String nombre, String apellido, String direccion) {
        
        Sql.sql = "insert into usuario (nombre, apellido, direccion) values('"+nombre+"', '"+apellido+"', '"+direccion+"')";
        Sql.conexion.ejecutarUpdate(Sql.sql);
    }
}