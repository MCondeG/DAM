/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejemplogeneraljpa.modelo.daos;

import com.ejemplogeneraljpa.modelo.entidades.Alumno;
import java.util.List;

/**
 *
 * @author manuelconde
 */
public interface IDaoAlumno {
    
    public Alumno verAlumno(int idAlumno);
    public List<Alumno> verAlumnos();
    public void crearAlumno(Alumno alumno);
    public void actualizarAlumno(int idAlumno, Alumno alumno);
    public void borrarAlumno(int idAlumno);
}