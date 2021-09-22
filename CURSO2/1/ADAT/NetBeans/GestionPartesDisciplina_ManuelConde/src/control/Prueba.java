/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;

import modelo.daos.*;

/**
 *
 * @author Ahbyss
 */
public class Prueba {
    
    public static void main(String args[]) throws SQLException {
    
        Dao dao = new Dao();
        DaoGrupo daoGru = new DaoGrupo();
        DaoAlumno daoAl = new DaoAlumno();
        DaoProfesor daoProf = new DaoProfesor();
        DaoParte daoPa = new DaoParte();
        
        
        //1. Crear un nuevo parte
        daoPa.crearParte();
       
        //2. Modificar un parte
        daoPa.modificarParte(1);
        
        //3. Borrar un parte
        daoPa.borrarParte(2);
        
        //4. Obtener los partes de un alumno
        daoAl.obtenerPartesAlumno(1);
        
        //5. Obtener los partes de un profesor
        daoProf.obtenerPartesProfesor(1);
        
        //6. Obtener los partes de un grupo (Número de partes)
        System.out.println(daoGru.contarPartesGrupo(1));
        
        //7. Obtener todos los partes
        daoPa.obtenerPartes();
        
        
        dao.getConexion().cerrarConexion();
    }
}