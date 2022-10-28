/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alumnoscrud.modelo.daos;

import com.alumnoscrud.modelo.daos.interfaces.IDaoAlumno;
import com.alumnoscrud.modelo.entidades.Alumno;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author manuelconde
 */
public class DaoAlumno extends Dao implements IDaoAlumno {
    
    public DaoAlumno() {
        super();
    }
    
    
    @Override
    public void añadir(Alumno alumno) {
        
        String nombre = alumno.getNombre();
        String observaciones = alumno.getObservaciones();
        int grupo = alumno.getGrupo().getId_grupo();
        
        String sql = "insert into alumno (nombre, observaciones, id_grupo) values('"+nombre+"', '"+observaciones+"', '"+grupo+"');";
        
        this.conexion.ejecutarUpdate(sql);
    }

    @Override
    public void eliminar(int id) {
        
        String sql = "delete from alumno where id_alumno = " + id + ";";
        
        this.conexion.ejecutarUpdate(sql);
    }

    @Override
    public void modificar(int id, Alumno nuevoAlumno) {

        String nombre = nuevoAlumno.getNombre();
        String observaciones = nuevoAlumno.getObservaciones();
        int grupo = nuevoAlumno.getGrupo().getId_grupo();
        
        String sql = "update alumno set nombre = '"+nombre+"', observaciones = '"+observaciones+"', id_grupo = '"+grupo+"' where id_alumno = " + id + ";";
        
        this.conexion.ejecutarUpdate(sql);
    }

    @Override
    public Alumno leer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void leerTodos() {
        
        String sql = "select * from alumno;";
        
        ResultSet resultado = this.conexion.ejecutarSQL(sql);
        
        this.conexion.mostrarRegistrosln();
        
        this.conexion.cerrarConexion();     
    }
}