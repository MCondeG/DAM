/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manuelcondegonzalez.semanacultural.vista;

import com.manuelcondegonzalez.semanacultural.control.ConexionBD;
import com.manuelcondegonzalez.semanacultural.modelo.daos.DaoProfesor;

/**
 *
 * @author manuelconde
 */
public class Prueba {
    
    public static void main(String[] args) {
        
        ConexionBD conexion = new ConexionBD("mysql", "ManuelCondeGonzalez-SemanaCultural", "root", "root");
        
        DaoProfesor dp = new DaoProfesor(conexion);
    }
}