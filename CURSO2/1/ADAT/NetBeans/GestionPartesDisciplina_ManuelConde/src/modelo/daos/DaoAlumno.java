/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.entidades.Alumno;
import modelo.entidades.Parte;
import modelo.interfacesDaos.*;

/**
 *
 * @author usuario
 */
public class DaoAlumno extends Dao implements IDaoAlumno {
    
    private ArrayList<Alumno> alumnos;
    
    
    public DaoAlumno() throws SQLException {
        
        this.entidad = "Alumno";
        this.rs = mapearRegistros(this.entidad, super.getConexion(), this.rs);
        
        this.alumnos = new ArrayList<>();
                    
        while(this.rs.next()) {
            this.alumnos.add(new Alumno(this.rs.getInt("idAlumno"), this.rs.getString("nombre")));
        }
        //this.rs.beforeFirst();
    }

    
    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    
    @Override
    public ArrayList<Parte> obtenerPartesAlumno(int idAlumno) {
        
        try {
            ArrayList<Parte> partes = new ArrayList<>();
            
            String sql = "select * from Parte, Alumno where Parte.Alumno_idAlumno = " + idAlumno +";";
            
            ResultSet rsPartes = super.getConexion().ejecutarSQL(sql);
            
            while(rsPartes.next()) {
                partes.add(new Parte(rsPartes.getInt("idParte")));
            }
            
            return partes;
        } catch (SQLException ex) {
            Logger.getLogger(DaoAlumno.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}