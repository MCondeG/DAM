/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.herenciajpa.modelo.daos;

import com.herenciajpa.modelo.entidades.Persona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author manuelconde
 */
public class DaoPersona {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    
    public DaoPersona(EntityManagerFactory emf) {   
        this.emf = emf;
        this.em = this.emf.createEntityManager();
    }

    
    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    
    public List<Persona> verPersonas() {
        
        TypedQuery <Persona> consulta = this.em.createNamedQuery("Persona.findAll", Persona.class);
                
        return (List<Persona>)consulta.getResultList();
    }
}