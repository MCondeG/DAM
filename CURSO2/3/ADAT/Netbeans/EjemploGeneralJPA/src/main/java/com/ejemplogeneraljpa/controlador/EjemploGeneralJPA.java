/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.ejemplogeneraljpa.controlador;

import com.ejemplogeneraljpa.modelo.daos.DaoAlumno;
import com.ejemplogeneraljpa.modelo.daos.DaoProfesor;
import com.ejemplogeneraljpa.modelo.entidades.Alumno;
import com.ejemplogeneraljpa.modelo.entidades.Profesor;
import java.util.List;

/**
 *
 * @author manuelconde
 */
public class EjemploGeneralJPA {

    public static void main(String[] args) {
        
        DaoAlumno daoA = new DaoAlumno();
        List<Alumno> listaAlumnos = null;
        
        DaoProfesor daoP = new DaoProfesor();
        
        
        
        // ------pruebas DaoAlumno-------
        
        /*
        //ver
        System.out.println(daoA.verAlumno(2) + "\n");
        
        listaAlumnos = daoA.verAlumnos();
        for(Alumno a : listaAlumnos) System.out.println(a);
        System.out.println();
        
        
        //crear
        Alumno a1 = new Alumno();
        a1.setNombre("alumno4");
        a1.setObservaciones("ej4");
        
        daoA.crearAlumno(a1);
        
        
        listaAlumnos = daoA.verAlumnos();
        for(Alumno a : listaAlumnos) System.out.println(a);
        System.out.println();

        
        //modificar
        Alumno a2 = new Alumno(); 
        a2.setNombre("alumnoModificado");
        a2.setObservaciones("ejModificado");
        
        daoA.actualizarAlumno(7, a2);
        
        
        listaAlumnos = daoA.verAlumnos();
        for(Alumno a : listaAlumnos) System.out.println(a);
        System.out.println();
        
        
        //borrar
        daoA.borrarAlumno(2);
        
        
        listaAlumnos = daoA.verAlumnos();
        for(Alumno a : listaAlumnos) System.out.println(a);
        System.out.println();
        */
        
        
        // -------pruebas DaoProfesor-------
        
        //crear
        Profesor p1 = new Profesor();
        p1.setNombre("profesorPrueba");
        p1.setObservaciones("ejemplo");
        p1.setIdAlumno(daoA.verAlumno(6));
        
        daoP.crearProfesor(p1);
    }
}