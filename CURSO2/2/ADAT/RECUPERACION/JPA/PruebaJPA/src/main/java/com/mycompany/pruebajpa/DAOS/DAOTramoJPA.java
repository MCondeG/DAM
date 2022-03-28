/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebajpa.DAOS;

import com.mycompany.pruebajpa.ENTITY.Posicion;
import com.mycompany.pruebajpa.ENTITY.Tramo;
import com.mycompany.pruebajpa.INTERFACES.IDAOPosicionJPA;
import com.mycompany.pruebajpa.INTERFACES.IDAOTramoJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rafa
 */
public class DAOTramoJPA implements IDAOTramoJPA {
    private EntityManagerFactory emf;
       
    public DAOTramoJPA (EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public void createTramo(Tramo tramo) {
        EntityManager em = null;
        
        try { 
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(tramo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Tramo> readTramos() {
        EntityManager em = this.getEntityManager();
        
        TypedQuery <Tramo> consulta = em.createNamedQuery("Tramo.findAll", Tramo.class);
        return consulta.getResultList();
    }
    
    @Override
    public void updateTramo(Tramo tramo) {
        EntityManager em = null;
        
        try { 
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.merge(tramo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
        @Override
    public void deleteTramo(Tramo tramo) {
        EntityManager em = null;
        
        try { 
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.merge(tramo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    
    
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

   
}
 
