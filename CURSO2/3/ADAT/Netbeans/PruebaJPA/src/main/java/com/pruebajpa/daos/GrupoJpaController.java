/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebajpa.daos;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.pruebajpa.entidades.Alumno;
import com.pruebajpa.entidades.Grupo;
import com.pruebajpa.exceptions.IllegalOrphanException;
import com.pruebajpa.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author manuelconde
 */
public class GrupoJpaController implements Serializable {

    public GrupoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Grupo grupo) {
        if (grupo.getAlumnoCollection() == null) {
            grupo.setAlumnoCollection(new ArrayList<Alumno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Alumno> attachedAlumnoCollection = new ArrayList<Alumno>();
            for (Alumno alumnoCollectionAlumnoToAttach : grupo.getAlumnoCollection()) {
                alumnoCollectionAlumnoToAttach = em.getReference(alumnoCollectionAlumnoToAttach.getClass(), alumnoCollectionAlumnoToAttach.getIdAlumno());
                attachedAlumnoCollection.add(alumnoCollectionAlumnoToAttach);
            }
            grupo.setAlumnoCollection(attachedAlumnoCollection);
            em.persist(grupo);
            for (Alumno alumnoCollectionAlumno : grupo.getAlumnoCollection()) {
                Grupo oldIdGrupoOfAlumnoCollectionAlumno = alumnoCollectionAlumno.getIdGrupo();
                alumnoCollectionAlumno.setIdGrupo(grupo);
                alumnoCollectionAlumno = em.merge(alumnoCollectionAlumno);
                if (oldIdGrupoOfAlumnoCollectionAlumno != null) {
                    oldIdGrupoOfAlumnoCollectionAlumno.getAlumnoCollection().remove(alumnoCollectionAlumno);
                    oldIdGrupoOfAlumnoCollectionAlumno = em.merge(oldIdGrupoOfAlumnoCollectionAlumno);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Grupo grupo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Grupo persistentGrupo = em.find(Grupo.class, grupo.getIdGrupo());
            Collection<Alumno> alumnoCollectionOld = persistentGrupo.getAlumnoCollection();
            Collection<Alumno> alumnoCollectionNew = grupo.getAlumnoCollection();
            List<String> illegalOrphanMessages = null;
            for (Alumno alumnoCollectionOldAlumno : alumnoCollectionOld) {
                if (!alumnoCollectionNew.contains(alumnoCollectionOldAlumno)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Alumno " + alumnoCollectionOldAlumno + " since its idGrupo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Alumno> attachedAlumnoCollectionNew = new ArrayList<Alumno>();
            for (Alumno alumnoCollectionNewAlumnoToAttach : alumnoCollectionNew) {
                alumnoCollectionNewAlumnoToAttach = em.getReference(alumnoCollectionNewAlumnoToAttach.getClass(), alumnoCollectionNewAlumnoToAttach.getIdAlumno());
                attachedAlumnoCollectionNew.add(alumnoCollectionNewAlumnoToAttach);
            }
            alumnoCollectionNew = attachedAlumnoCollectionNew;
            grupo.setAlumnoCollection(alumnoCollectionNew);
            grupo = em.merge(grupo);
            for (Alumno alumnoCollectionNewAlumno : alumnoCollectionNew) {
                if (!alumnoCollectionOld.contains(alumnoCollectionNewAlumno)) {
                    Grupo oldIdGrupoOfAlumnoCollectionNewAlumno = alumnoCollectionNewAlumno.getIdGrupo();
                    alumnoCollectionNewAlumno.setIdGrupo(grupo);
                    alumnoCollectionNewAlumno = em.merge(alumnoCollectionNewAlumno);
                    if (oldIdGrupoOfAlumnoCollectionNewAlumno != null && !oldIdGrupoOfAlumnoCollectionNewAlumno.equals(grupo)) {
                        oldIdGrupoOfAlumnoCollectionNewAlumno.getAlumnoCollection().remove(alumnoCollectionNewAlumno);
                        oldIdGrupoOfAlumnoCollectionNewAlumno = em.merge(oldIdGrupoOfAlumnoCollectionNewAlumno);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = grupo.getIdGrupo();
                if (findGrupo(id) == null) {
                    throw new NonexistentEntityException("The grupo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Grupo grupo;
            try {
                grupo = em.getReference(Grupo.class, id);
                grupo.getIdGrupo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The grupo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Alumno> alumnoCollectionOrphanCheck = grupo.getAlumnoCollection();
            for (Alumno alumnoCollectionOrphanCheckAlumno : alumnoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Grupo (" + grupo + ") cannot be destroyed since the Alumno " + alumnoCollectionOrphanCheckAlumno + " in its alumnoCollection field has a non-nullable idGrupo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(grupo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Grupo> findGrupoEntities() {
        return findGrupoEntities(true, -1, -1);
    }

    public List<Grupo> findGrupoEntities(int maxResults, int firstResult) {
        return findGrupoEntities(false, maxResults, firstResult);
    }

    private List<Grupo> findGrupoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Grupo.class));
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

    public Grupo findGrupo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Grupo.class, id);
        } finally {
            em.close();
        }
    }

    public int getGrupoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Grupo> rt = cq.from(Grupo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
