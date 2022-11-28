/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplogeneraljpa.modelo.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author manuelconde
 */

public class Dao {
    
    protected EntityManagerFactory emf;
    
    
    public Dao() {
        this.emf = Persistence.createEntityManagerFactory("EjemploGeneralJPA_PU");
    }
    

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        
        return this.emf.createEntityManager(); 
    }
}