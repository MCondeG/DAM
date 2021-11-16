/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import entidades.Profesor;
import entidades.Taller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author enrique
 */


public class DaoProfesor implements InterfaceDaoProfesor{
    
    
    
    private EntityManagerFactory emf = null;
   
    public DaoProfesor(EntityManagerFactory emf) {
        this.emf = emf;
    }
   

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
 


    @Override
    public void crearProfesor(Profesor profesor) {
        
         EntityManager em=null;
        
        try { 
            em=this.getEntityManager();
            em.getTransaction().begin();
            em.persist(profesor);
            em.getTransaction().commit();
          
        } finally {
            em.close();
        }

    }

    @Override
    public void actualizarProfesor(Profesor profesor) {
            EntityManager em=null;
        
        try { 
            em=this.getEntityManager();
            em.getTransaction().begin();
            em.merge(profesor);
            em.getTransaction().commit();
          
        } finally {
            em.close();
        }


    }

    @Override
    public void borrarProfesor(Profesor profesor) {
        
        EntityManager em=null;
        
        try { 
            em=this.getEntityManager();
            em.getTransaction().begin();
            em.remove(profesor);
            em.getTransaction().commit();
          
        } finally {
            em.close();
        }
    }
    
    
    
    @Override
    public List<Profesor> verProfesores() {
        
        EntityManager em=this.getEntityManager();
        
        TypedQuery <Profesor> consulta=em.createNamedQuery("Profesor.findAll",Profesor.class);
       
        
        
        return (List<Profesor>)consulta.getResultList();
      

    }

    @Override
    public Profesor getProfesor(int idProfesor) {
        
        EntityManager em=this.getEntityManager();
        
        try {
           return em.find(Profesor.class, idProfesor);
        } finally {
            em.close();
        }

    }

    @Override
    public Profesor getProfesor(String nombre) {
        
        EntityManager em=this.getEntityManager();
        TypedQuery <Profesor> consulta=em.createNamedQuery("findByNombre",Profesor.class);
        consulta.setParameter("enrique", Profesor.class);
        
        
        return (Profesor)consulta.getSingleResult();


    }

    @Override
    public List<Taller> getTalleres(Profesor profesor) {
        
        return profesor.getTallerList();
    }
    
}
