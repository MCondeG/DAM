/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alumnoscrud.modelo.daos;

import com.alumnoscrud.modelo.entidades.Alumno;
import com.alumnoscrud.modelo.utilidades.ConexionBD;
import java.util.ArrayList;

/**
 *
 * @author manuelconde
 */

public class Dao {
    
    protected ConexionBD conexion;
    
    
    public Dao() {
        
        this.conexion = new ConexionBD("mysql", "AlumnosBD", "root", "root");
    }
}