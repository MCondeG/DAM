/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplogeneraljpa.modelo.daos;

import com.ejemplogeneraljpa.modelo.entidades.Profesor;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author manuelconde
 */
public class DaoProfesor extends Dao implements IDaoProfesor {
    
    
    public DaoProfesor() {
        super();
    }
    

    @Override
    public Profesor verProfesor(int idProfesor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Profesor> verProfesores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void crearProfesor(Profesor profesor) {
        
        EntityManager em = null;
        
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(profesor);
            em.getTransaction().commit();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void actualizarProfesor(int idProfesor, Profesor profesor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void borrarProfesor(int idProfesor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}