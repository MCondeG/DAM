/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manuelconde_examenada1.modelo.daos;

import com.manuelconde_examenada1.modelo.daos.interfaces.IDaoAlimento;
import com.manuelconde_examenada1.modelo.entidades.Alimento;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author manuelconde
 */
public class DaoAlimento implements IDaoAlimento {

    private EntityManagerFactory emf;

    
    public DaoAlimento() {
        this.emf = Persistence.createEntityManagerFactory("ManuelConde_ExamenADA1_PU");
    }
    
    public EntityManager getEntityManager() {
        
        return this.emf.createEntityManager(); 
    }
    
    
    @Override
    public void crearAlimento(Alimento alimento) {
        
        EntityManager em = null;
        
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(alimento);
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