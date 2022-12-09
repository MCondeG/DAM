/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manuelconde_examenada1.modelo.daos;

import com.manuelconde_examenada1.modelo.daos.interfaces.IDaoIngrediente;
import com.manuelconde_examenada1.modelo.entidades.Ingrediente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author manuelconde
 */
public class DaoIngrediente implements IDaoIngrediente {
    
    
    private EntityManagerFactory emf;

    
    public DaoIngrediente() {
        this.emf = Persistence.createEntityManagerFactory("ManuelConde_ExamenADA1_PU");
    }

    public EntityManager getEntityManager() {
        
        return this.emf.createEntityManager(); 
    }
    
    
    @Override
    public void crearIngrediente(Ingrediente ingrediente) {
        EntityManager em = null;
        
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(ingrediente);
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