/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semanacultural;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import semanacultural.exceptions.NonexistentEntityException;
import semanacultural.exceptions.PreexistingEntityException;

/**
 *
 * @author enrique
 */
public class TalleresJpaController implements Serializable {

    public TalleresJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Talleres talleres) throws PreexistingEntityException, Exception {
        if (talleres.getAlumnosSet() == null) {
            talleres.setAlumnosSet(new HashSet<Alumnos>());
        }
        EntityManager em = null;
        
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Set<Alumnos> attachedAlumnosSet = new HashSet<Alumnos>();
            for (Alumnos alumnosSetAlumnosToAttach : talleres.getAlumnosSet()) {
                alumnosSetAlumnosToAttach = em.getReference(alumnosSetAlumnosToAttach.getClass(), alumnosSetAlumnosToAttach.getIdalumno());
                attachedAlumnosSet.add(alumnosSetAlumnosToAttach);
            }
            talleres.setAlumnosSet(attachedAlumnosSet);
            em.persist(talleres);
            for (Alumnos alumnosSetAlumnos : talleres.getAlumnosSet()) {
                alumnosSetAlumnos.getTalleresSet().add(talleres);
                alumnosSetAlumnos = em.merge(alumnosSetAlumnos);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTalleres(talleres.getIdTaller()) != null) {
                throw new PreexistingEntityException("Talleres " + talleres + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Talleres talleres) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Talleres persistentTalleres = em.find(Talleres.class, talleres.getIdTaller());
            Set<Alumnos> alumnosSetOld = persistentTalleres.getAlumnosSet();
            Set<Alumnos> alumnosSetNew = talleres.getAlumnosSet();
            Set<Alumnos> attachedAlumnosSetNew = new HashSet<Alumnos>();
            for (Alumnos alumnosSetNewAlumnosToAttach : alumnosSetNew) {
                alumnosSetNewAlumnosToAttach = em.getReference(alumnosSetNewAlumnosToAttach.getClass(), alumnosSetNewAlumnosToAttach.getIdalumno());
                attachedAlumnosSetNew.add(alumnosSetNewAlumnosToAttach);
            }
            alumnosSetNew = attachedAlumnosSetNew;
            talleres.setAlumnosSet(alumnosSetNew);
            talleres = em.merge(talleres);
            for (Alumnos alumnosSetOldAlumnos : alumnosSetOld) {
                if (!alumnosSetNew.contains(alumnosSetOldAlumnos)) {
                    alumnosSetOldAlumnos.getTalleresSet().remove(talleres);
                    alumnosSetOldAlumnos = em.merge(alumnosSetOldAlumnos);
                }
            }
            for (Alumnos alumnosSetNewAlumnos : alumnosSetNew) {
                if (!alumnosSetOld.contains(alumnosSetNewAlumnos)) {
                    alumnosSetNewAlumnos.getTalleresSet().add(talleres);
                    alumnosSetNewAlumnos = em.merge(alumnosSetNewAlumnos);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = talleres.getIdTaller();
                if (findTalleres(id) == null) {
                    throw new NonexistentEntityException("The talleres with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Talleres talleres;
            try {
                talleres = em.getReference(Talleres.class, id);
                talleres.getIdTaller();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The talleres with id " + id + " no longer exists.", enfe);
            }
            Set<Alumnos> alumnosSet = talleres.getAlumnosSet();
            for (Alumnos alumnosSetAlumnos : alumnosSet) {
                alumnosSetAlumnos.getTalleresSet().remove(talleres);
                alumnosSetAlumnos = em.merge(alumnosSetAlumnos);
            }
            em.remove(talleres);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Talleres> findTalleresEntities() {
        return findTalleresEntities(true, -1, -1);
    }

    public List<Talleres> findTalleresEntities(int maxResults, int firstResult) {
        return findTalleresEntities(false, maxResults, firstResult);
    }

    private List<Talleres> findTalleresEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Talleres.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Talleres findTalleres(Integer id) {
        EntityManager em = getEntityManager();
        try {
            
            return em.find(Talleres.class, id);
            
        } finally {
            em.close();
        }
    }
    
      public Talleres findTalleresName(String name) {
        EntityManager em = getEntityManager();
        try {
            
            Query query=em.createNamedQuery("Talleres.findByNombre");
            query.setParameter("nombre",name);
            List<Talleres> listaTalleres=query.getResultList();
            
            return listaTalleres.get(0);
            
        } 
        finally {
            em.close();
          
           
        }
    }

    public int getTalleresCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Talleres> rt = cq.from(Talleres.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
