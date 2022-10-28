/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.alumnoscrud;

import com.alumnoscrud.modelo.daos.DaoAlumno;
import com.alumnoscrud.modelo.entidades.Alumno;
import com.alumnoscrud.modelo.entidades.Grupo;
import com.alumnoscrud.vista.Ventana;

/**
 *
 * @author manuelconde
 */
public class AlumnosCRUD {

    public static void main(String[] args) {
        
        
        /*** PRUEBAS
        
        DaoAlumno d = new DaoAlumno();
        
        
        Grupo g = new Grupo(1, "prueba1", "prueba1");
        Grupo g2 = new Grupo(2, "pruebaModificado", "pruebaModificado");
        Alumno alu = new Alumno("prueba1", "prueba1", g);
        Alumno alu2 = new Alumno("pruebaModificado", "pruebaModificado", g2);
        
        
        d.leerTodos();
        d.añadir(alu);
        d.eliminar(5);
        d.modificar(6, alu2);
        d.leerTodos();
        
        /***************/
        
                
        Ventana.iniciar();
    }
}