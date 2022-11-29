/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manuelconde_examenada1.modelo.daos;

import com.manuelconde_examenada1.modelo.daos.interfaces.IDaoReceta;
import com.manuelconde_examenada1.modelo.entidades.Alimento;
import com.manuelconde_examenada1.modelo.entidades.Ingrediente;
import com.manuelconde_examenada1.modelo.entidades.Receta;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author manuelconde
 */
public class DaoReceta implements IDaoReceta {
    
    
    private EntityManagerFactory emf;

    
    public DaoReceta() {
        this.emf = Persistence.createEntityManagerFactory("ManuelConde_ExamenADA1_PU");
    }
    
    public EntityManager getEntityManager() {
        
        return this.emf.createEntityManager(); 
    }

    
    @Override
    public void crearReceta(Receta receta) {
        
        EntityManager em = null;
        
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(receta);
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
    public void actualizarReceta(String nombre) {
        
        EntityManager em = null;
        
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            
            Alimento a = new Alimento();
            a.setNombre("queso");
            Ingrediente i = new Ingrediente();
            i.setIdAlimento(a);
            
            Receta r = em.find(Receta.class, nombre);
            
            r.getIngredienteList().add(i);
            
            em.merge(r);
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