/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplogeneraljpa.modelo.daos;

import com.ejemplogeneraljpa.modelo.entidades.Alumno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author manuelconde
 */
public class DaoAlumno extends Dao implements IDaoAlumno {
    
    
    public DaoAlumno() {
        super();
    }

    
    @Override
    public Alumno verAlumno(int idAlumno) {
        
        EntityManager em = this.getEntityManager();
        Alumno a = null;
       
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            a = em.find(Alumno.class, idAlumno);
            em.getTransaction().commit();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            em.close();
        }
        
        return a;
    }

    @Override
    public List<Alumno> verAlumnos() {
        
        EntityManager em = this.getEntityManager();
        
        TypedQuery <Alumno> consulta = em.createNamedQuery("Alumno.findAll", Alumno.class);
        
        return (List<Alumno>)consulta.getResultList();
    }

    @Override
    public void crearAlumno(Alumno alumno) {
        
        EntityManager em = null;
        
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(alumno);
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
    public void actualizarAlumno(int idAlumno, Alumno alumno) {
        
        EntityManager em = null;
        
        try {
            em = this.getEntityManager();
            
            em.getTransaction().begin();
            
            Alumno a = em.find(Alumno.class, idAlumno);
            a.setNombre(alumno.getNombre());
            a.setObservaciones(alumno.getObservaciones());
            
            em.merge(a);
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
    public void borrarAlumno(int idAlumno) {
        
        EntityManager em = null;
        
        try {
            em = this.getEntityManager();
            
            em.getTransaction().begin();
            
            Alumno a = em.find(Alumno.class, idAlumno);
            
            em.remove(a);
            em.getTransaction().commit();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            em.close();
        }
    }
}