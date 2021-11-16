package controllerJpa;

import modeloJpa.*;
import excepciones.IllegalOrphanException;
import excepciones.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ProfesorJpaController implements Serializable {

    public ProfesorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Profesor profesor) {
        if (profesor.getTallerList() == null) {
            profesor.setTallerList(new ArrayList<Taller>());
        }
        if (profesor.getGrupoList() == null) {
            profesor.setGrupoList(new ArrayList<Grupo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Taller> attachedTallerList = new ArrayList<Taller>();
            for (Taller tallerListTallerToAttach : profesor.getTallerList()) {
                tallerListTallerToAttach = em.getReference(tallerListTallerToAttach.getClass(), tallerListTallerToAttach.getIdTaller());
                attachedTallerList.add(tallerListTallerToAttach);
            }
            profesor.setTallerList(attachedTallerList);
            List<Grupo> attachedGrupoList = new ArrayList<Grupo>();
            for (Grupo grupoListGrupoToAttach : profesor.getGrupoList()) {
                grupoListGrupoToAttach = em.getReference(grupoListGrupoToAttach.getClass(), grupoListGrupoToAttach.getIdGrupo());
                attachedGrupoList.add(grupoListGrupoToAttach);
            }
            profesor.setGrupoList(attachedGrupoList);
            em.persist(profesor);
            for (Taller tallerListTaller : profesor.getTallerList()) {
                Profesor oldProfesorIdProfesorOfTallerListTaller = tallerListTaller.getProfesorIdProfesor();
                tallerListTaller.setProfesorIdProfesor(profesor);
                tallerListTaller = em.merge(tallerListTaller);
                if (oldProfesorIdProfesorOfTallerListTaller != null) {
                    oldProfesorIdProfesorOfTallerListTaller.getTallerList().remove(tallerListTaller);
                    oldProfesorIdProfesorOfTallerListTaller = em.merge(oldProfesorIdProfesorOfTallerListTaller);
                }
            }
            for (Grupo grupoListGrupo : profesor.getGrupoList()) {
                Profesor oldIdProfesorOfGrupoListGrupo = grupoListGrupo.getIdProfesor();
                grupoListGrupo.setIdProfesor(profesor);
                grupoListGrupo = em.merge(grupoListGrupo);
                if (oldIdProfesorOfGrupoListGrupo != null) {
                    oldIdProfesorOfGrupoListGrupo.getGrupoList().remove(grupoListGrupo);
                    oldIdProfesorOfGrupoListGrupo = em.merge(oldIdProfesorOfGrupoListGrupo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Profesor profesor) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Profesor persistentProfesor = em.find(Profesor.class, profesor.getIdProfesor());
            List<Taller> tallerListOld = persistentProfesor.getTallerList();
            List<Taller> tallerListNew = profesor.getTallerList();
            List<Grupo> grupoListOld = persistentProfesor.getGrupoList();
            List<Grupo> grupoListNew = profesor.getGrupoList();
            List<String> illegalOrphanMessages = null;
            for (Taller tallerListOldTaller : tallerListOld) {
                if (!tallerListNew.contains(tallerListOldTaller)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Taller " + tallerListOldTaller + " since its profesorIdProfesor field is not nullable.");
                }
            }
            for (Grupo grupoListOldGrupo : grupoListOld) {
                if (!grupoListNew.contains(grupoListOldGrupo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Grupo " + grupoListOldGrupo + " since its idProfesor field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Taller> attachedTallerListNew = new ArrayList<Taller>();
            for (Taller tallerListNewTallerToAttach : tallerListNew) {
                tallerListNewTallerToAttach = em.getReference(tallerListNewTallerToAttach.getClass(), tallerListNewTallerToAttach.getIdTaller());
                attachedTallerListNew.add(tallerListNewTallerToAttach);
            }
            tallerListNew = attachedTallerListNew;
            profesor.setTallerList(tallerListNew);
            List<Grupo> attachedGrupoListNew = new ArrayList<Grupo>();
            for (Grupo grupoListNewGrupoToAttach : grupoListNew) {
                grupoListNewGrupoToAttach = em.getReference(grupoListNewGrupoToAttach.getClass(), grupoListNewGrupoToAttach.getIdGrupo());
                attachedGrupoListNew.add(grupoListNewGrupoToAttach);
            }
            grupoListNew = attachedGrupoListNew;
            profesor.setGrupoList(grupoListNew);
            profesor = em.merge(profesor);
            for (Taller tallerListNewTaller : tallerListNew) {
                if (!tallerListOld.contains(tallerListNewTaller)) {
                    Profesor oldProfesorIdProfesorOfTallerListNewTaller = tallerListNewTaller.getProfesorIdProfesor();
                    tallerListNewTaller.setProfesorIdProfesor(profesor);
                    tallerListNewTaller = em.merge(tallerListNewTaller);
                    if (oldProfesorIdProfesorOfTallerListNewTaller != null && !oldProfesorIdProfesorOfTallerListNewTaller.equals(profesor)) {
                        oldProfesorIdProfesorOfTallerListNewTaller.getTallerList().remove(tallerListNewTaller);
                        oldProfesorIdProfesorOfTallerListNewTaller = em.merge(oldProfesorIdProfesorOfTallerListNewTaller);
                    }
                }
            }
            for (Grupo grupoListNewGrupo : grupoListNew) {
                if (!grupoListOld.contains(grupoListNewGrupo)) {
                    Profesor oldIdProfesorOfGrupoListNewGrupo = grupoListNewGrupo.getIdProfesor();
                    grupoListNewGrupo.setIdProfesor(profesor);
                    grupoListNewGrupo = em.merge(grupoListNewGrupo);
                    if (oldIdProfesorOfGrupoListNewGrupo != null && !oldIdProfesorOfGrupoListNewGrupo.equals(profesor)) {
                        oldIdProfesorOfGrupoListNewGrupo.getGrupoList().remove(grupoListNewGrupo);
                        oldIdProfesorOfGrupoListNewGrupo = em.merge(oldIdProfesorOfGrupoListNewGrupo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = profesor.getIdProfesor();
                if (findProfesor(id) == null) {
                    throw new NonexistentEntityException("The profesor with id " + id + " no longer exists.");
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
            Profesor profesor;
            try {
                profesor = em.getReference(Profesor.class, id);
                profesor.getIdProfesor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The profesor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Taller> tallerListOrphanCheck = profesor.getTallerList();
            for (Taller tallerListOrphanCheckTaller : tallerListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Profesor (" + profesor + ") cannot be destroyed since the Taller " + tallerListOrphanCheckTaller + " in its tallerList field has a non-nullable profesorIdProfesor field.");
            }
            List<Grupo> grupoListOrphanCheck = profesor.getGrupoList();
            for (Grupo grupoListOrphanCheckGrupo : grupoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Profesor (" + profesor + ") cannot be destroyed since the Grupo " + grupoListOrphanCheckGrupo + " in its grupoList field has a non-nullable idProfesor field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(profesor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Profesor> findProfesorEntities() {
        return findProfesorEntities(true, -1, -1);
    }

    public List<Profesor> findProfesorEntities(int maxResults, int firstResult) {
        return findProfesorEntities(false, maxResults, firstResult);
    }

    private List<Profesor> findProfesorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Profesor.class));
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

    public Profesor findProfesor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Profesor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProfesorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Profesor> rt = cq.from(Profesor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
