package daoJpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import modeloJpa.*;

public class DaoProfesorJpa implements DaoProfesor{
    
    private EntityManagerFactory emf = null;
   
    public DaoProfesorJpa(EntityManagerFactory emf) {
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
        consulta.setParameter(nombre, Profesor.class);      
        return (Profesor)consulta.getSingleResult();
    }

    @Override
    public List<Taller> getTalleres(Profesor profesor) {     
        return profesor.getTallerList();
    }
    
}

