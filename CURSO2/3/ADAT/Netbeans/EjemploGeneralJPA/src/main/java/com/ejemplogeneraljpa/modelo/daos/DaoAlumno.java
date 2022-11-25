/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplogeneraljpa.modelo.daos;

import com.ejemplogeneraljpa.modelo.entidades.Alumno;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author manuelconde
 */
public class DaoAlumno extends Dao implements IDaoAlumno {
    
    
    public DaoAlumno(EntityManagerFactory emf) {
        super(emf);
    }

    
    @Override
    public Alumno verAlumno(int idAlumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> verAlumnos() {
        
        TypedQuery <Alumno> consulta = this.em.createNamedQuery("Alumno.findAll", Alumno.class);
        
        return (List<Alumno>)consulta.getResultList();
    }

    @Override
    public void crearAlumno(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarAlumno(int idAlumno, Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrarAlumno(int idAlumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}