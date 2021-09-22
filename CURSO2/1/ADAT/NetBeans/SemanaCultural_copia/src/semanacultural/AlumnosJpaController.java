/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semanacultural;

import java.io.Serializable;
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
public class AlumnosJpaController implements Serializable {

    public AlumnosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Alumnos alumnos) throws PreexistingEntityException, Exception {
        if (alumnos.getTalleresSet() == null) {
            alumnos.setTalleresSet(new HashSet<Talleres>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Set<Talleres> attachedTalleresSet = new HashSet<Talleres>();
            for (Talleres talleresSetTalleresToAttach : alumnos.getTalleresSet()) {
                talleresSetTalleresToAttach = em.getReference(talleresSetTalleresToAttach.getClass(), talleresSetTalleresToAttach.getIdTaller());
                attachedTalleresSet.add(talleresSetTalleresToAttach);
            }
            alumnos.setTalleresSet(attachedTalleresSet);
            em.persist(alumnos);
            for (Talleres talleresSetTalleres : alumnos.getTalleresSet()) {
                talleresSetTalleres.getAlumnosSet().add(alumnos);
                talleresSetTalleres = em.merge(talleresSetTalleres);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAlumnos(alumnos.getIdalumno()) != null) {
                throw new PreexistingEntityException("Alumnos " + alumnos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Alumnos alumnos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alumnos persistentAlumnos = em.find(Alumnos.class, alumnos.getIdalumno());
            Set<Talleres> talleresSetOld = persistentAlumnos.getTalleresSet();
            Set<Talleres> talleresSetNew = alumnos.getTalleresSet();
            Set<Talleres> attachedTalleresSetNew = new HashSet<Talleres>();
            for (Talleres talleresSetNewTalleresToAttach : talleresSetNew) {
                talleresSetNewTalleresToAttach = em.getReference(talleresSetNewTalleresToAttach.getClass(), talleresSetNewTalleresToAttach.getIdTaller());
                attachedTalleresSetNew.add(talleresSetNewTalleresToAttach);
            }
            talleresSetNew = attachedTalleresSetNew;
            alumnos.setTalleresSet(talleresSetNew);
            alumnos = em.merge(alumnos);
            for (Talleres talleresSetOldTalleres : talleresSetOld) {
                if (!talleresSetNew.contains(talleresSetOldTalleres)) {
                    talleresSetOldTalleres.getAlumnosSet().remove(alumnos);
                    talleresSetOldTalleres = em.merge(talleresSetOldTalleres);
                }
            }
            for (Talleres talleresSetNewTalleres : talleresSetNew) {
                if (!talleresSetOld.contains(talleresSetNewTalleres)) {
                    talleresSetNewTalleres.getAlumnosSet().add(alumnos);
                    talleresSetNewTalleres = em.merge(talleresSetNewTalleres);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = alumnos.getIdalumno();
                if (findAlumnos(id) == null) {
                    throw new NonexistentEntityException("The alumnos with id " + id + " no longer exists.");
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
            Alumnos alumnos;
            try {
                alumnos = em.getReference(Alumnos.class, id);
                alumnos.getIdalumno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alumnos with id " + id + " no longer exists.", enfe);
            }
            Set<Talleres> talleresSet = alumnos.getTalleresSet();
            for (Talleres talleresSetTalleres : talleresSet) {
                talleresSetTalleres.getAlumnosSet().remove(alumnos);
                talleresSetTalleres = em.merge(talleresSetTalleres);
            }
            em.remove(alumnos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Alumnos> findAlumnosEntities() {
        return findAlumnosEntities(true, -1, -1);
    }

    public List<Alumnos> findAlumnosEntities(int maxResults, int firstResult) {
        return findAlumnosEntities(false, maxResults, firstResult);
    }

    private List<Alumnos> findAlumnosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alumnos.class));
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

    public Alumnos findAlumnos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alumnos.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlumnosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alumnos> rt = cq.from(Alumnos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
