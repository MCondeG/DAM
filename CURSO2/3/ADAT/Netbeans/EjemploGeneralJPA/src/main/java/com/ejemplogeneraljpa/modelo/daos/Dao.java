/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplogeneraljpa.modelo.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author manuelconde
 */

public class Dao {
    
    protected EntityManagerFactory emf;
    protected EntityManager em;
    
    
    public Dao(EntityManagerFactory emf) {
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
}