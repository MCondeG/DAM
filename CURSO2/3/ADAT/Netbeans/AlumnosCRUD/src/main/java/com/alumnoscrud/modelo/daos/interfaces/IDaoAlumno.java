/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.alumnoscrud.modelo.daos.interfaces;

import com.alumnoscrud.modelo.entidades.Alumno;

/**
 *
 * @author manuelconde
 */
public interface IDaoAlumno {
    
    public void añadir(Alumno alumno);
    
    public void eliminar(int id);
    
    public void modificar(int id, Alumno nuevoAlumno);
    
    public Alumno leer(int id);
    
    public void leerTodos();
}