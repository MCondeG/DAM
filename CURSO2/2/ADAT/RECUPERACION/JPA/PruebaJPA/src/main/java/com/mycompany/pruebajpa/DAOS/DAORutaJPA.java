/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebajpa.DAOS;

import com.mycompany.pruebajpa.ENTITY.Ruta;
import com.mycompany.pruebajpa.ENTITY.Tramo;
import com.mycompany.pruebajpa.INTERFACES.IDAORutaJPA;
import com.mycompany.pruebajpa.INTERFACES.IDAOTramoJPA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rafa
 */
public class DAORutaJPA implements IDAORutaJPA {
    private EntityManagerFactory emf;
       
    public DAORutaJPA (EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public void createRuta(Ruta ruta) {
        EntityManager em = null;
        
        try { 
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(ruta);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Ruta> readRutas() {
        EntityManager em = this.getEntityManager();
        
        TypedQuery <Ruta> consulta = em.createNamedQuery("Ruta.findAll", Ruta.class);
        return consulta.getResultList();
    }
    
    @Override
    public void updateRuta(Ruta ruta) {
        EntityManager em = null;
        
        try { 
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.merge(ruta);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

   
}