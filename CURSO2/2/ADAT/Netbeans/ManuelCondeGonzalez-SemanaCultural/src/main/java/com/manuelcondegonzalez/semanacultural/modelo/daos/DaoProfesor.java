/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manuelcondegonzalez.semanacultural.modelo.daos;

import com.manuelcondegonzalez.semanacultural.control.ConexionBD;
import com.manuelcondegonzalez.semanacultural.modelo.entidades.Profesor;
import com.manuelcondegonzalez.semanacultural.modelo.interfacesDao.IDaoProfesor;
import java.util.ArrayList;

/**
 *
 * @author manuelconde
 */
public class DaoProfesor implements IDaoProfesor {
    
    private ConexionBD conexion;
    
    
    public DaoProfesor() {
        
    }
    
    public DaoProfesor(ConexionBD conexion) {
        this.conexion = conexion;
    }
    
    
    @Override
    public boolean createProfesor(Profesor p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateProfesor(int id, Profesor p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteProfesor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Profesor> readProfesor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Profesor readProfesorById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}