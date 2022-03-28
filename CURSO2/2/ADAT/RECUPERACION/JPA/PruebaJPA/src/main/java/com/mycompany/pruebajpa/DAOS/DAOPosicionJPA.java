/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebajpa.DAOS;

import com.mycompany.pruebajpa.DAOS.exceptions.NonexistentEntityException;
import com.mycompany.pruebajpa.ENTITY.Posicion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.pruebajpa.ENTITY.Tramo;
import com.mycompany.pruebajpa.INTERFACES.IDAOPosicionJPA;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rafa
 */
public class DAOPosicionJPA implements IDAOPosicionJPA {
    private EntityManagerFactory emf;
       
    public DAOPosicionJPA (EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public void createPosicion(Posicion posicion) {
        EntityManager em = null;
        
        try { 
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(posicion);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Posicion> readPosiciones() {
        EntityManager em = this.getEntityManager();
        
        TypedQuery <Posicion> consulta = em.createNamedQuery("Posicion.findAll", Posicion.class);
        return consulta.getResultList();
    }
    
    @Override
    public void updatePosicion(Posicion posicion) {
        EntityManager em = null;
        
        try { 
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.merge(posicion);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

   
}
 