/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usuarioscrud.modelo;

import java.util.ArrayList;

/**
 *
 * @author manuelconde
 */
public abstract class Modelo {
    
    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    
    
    public static void añadir(String nombre, String apellido, String direccion) {
        
        usuarios.add(new Usuario(nombre, apellido, direccion));
    }
    
    public static void listar() {
        
        for(Usuario u: usuarios) {
            
            System.out.println(u);
        }
    }
}