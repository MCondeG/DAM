package controllerJpa;

import modeloJpa.*;
import excepciones.IllegalOrphanException;
import excepciones.NonexistentEntityException;
import excepciones.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class GrupoJpaController implements Serializable {

    public GrupoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Grupo grupo) throws PreexistingEntityException, Exception {
        if (grupo.getAlumnoList() == null) {
            grupo.setAlumnoList(new ArrayList<Alumno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Profesor idProfesor = grupo.getIdProfesor();
            if (idProfesor != null) {
                idProfesor = em.getReference(idProfesor.getClass(), idProfesor.getIdProfesor());
                grupo.setIdProfesor(idProfesor);
            }
            List<Alumno> attachedAlumnoList = new ArrayList<Alumno>();
            for (Alumno alumnoListAlumnoToAttach : grupo.getAlumnoList()) {
                alumnoListAlumnoToAttach = em.getReference(alumnoListAlumnoToAttach.getClass(), alumnoListAlumnoToAttach.getIdAlumno());
                attachedAlumnoList.add(alumnoListAlumnoToAttach);
            }
            grupo.setAlumnoList(attachedAlumnoList);
            em.persist(grupo);
            if (idProfesor != null) {
                idProfesor.getGrupoList().add(grupo);
                idProfesor = em.merge(idProfesor);
            }
            for (Alumno alumnoListAlumno : grupo.getAlumnoList()) {
                Grupo oldIdGrupoOfAlumnoListAlumno = alumnoListAlumno.getIdGrupo();
                alumnoListAlumno.setIdGrupo(grupo);
                alumnoListAlumno = em.merge(alumnoListAlumno);
                if (oldIdGrupoOfAlumnoListAlumno != null) {
                    oldIdGrupoOfAlumnoListAlumno.getAlumnoList().remove(alumnoListAlumno);
                    oldIdGrupoOfAlumnoListAlumno = em.merge(oldIdGrupoOfAlumnoListAlumno);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGrupo(grupo.getIdGrupo()) != null) {
                throw new PreexistingEntityException("Grupo " + grupo + " already exists.", ex);
            }
            throw ex;
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
            Profesor idProfesorOld = persistentGrupo.getIdProfesor();
            Profesor idProfesorNew = grupo.getIdProfesor();
            List<Alumno> alumnoListOld = persistentGrupo.getAlumnoList();
            List<Alumno> alumnoListNew = grupo.getAlumnoList();
            List<String> illegalOrphanMessages = null;
            for (Alumno alumnoListOldAlumno : alumnoListOld) {
                if (!alumnoListNew.contains(alumnoListOldAlumno)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Alumno " + alumnoListOldAlumno + " since its idGrupo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idProfesorNew != null) {
                idProfesorNew = em.getReference(idProfesorNew.getClass(), idProfesorNew.getIdProfesor());
                grupo.setIdProfesor(idProfesorNew);
            }
            List<Alumno> attachedAlumnoListNew = new ArrayList<Alumno>();
            for (Alumno alumnoListNewAlumnoToAttach : alumnoListNew) {
                alumnoListNewAlumnoToAttach = em.getReference(alumnoListNewAlumnoToAttach.getClass(), alumnoListNewAlumnoToAttach.getIdAlumno());
                attachedAlumnoListNew.add(alumnoListNewAlumnoToAttach);
            }
            alumnoListNew = attachedAlumnoListNew;
            grupo.setAlumnoList(alumnoListNew);
            grupo = em.merge(grupo);
            if (idProfesorOld != null && !idProfesorOld.equals(idProfesorNew)) {
                idProfesorOld.getGrupoList().remove(grupo);
                idProfesorOld = em.merge(idProfesorOld);
            }
            if (idProfesorNew != null && !idProfesorNew.equals(idProfesorOld)) {
                idProfesorNew.getGrupoList().add(grupo);
                idProfesorNew = em.merge(idProfesorNew);
            }
            for (Alumno alumnoListNewAlumno : alumnoListNew) {
                if (!alumnoListOld.contains(alumnoListNewAlumno)) {
                    Grupo oldIdGrupoOfAlumnoListNewAlumno = alumnoListNewAlumno.getIdGrupo();
                    alumnoListNewAlumno.setIdGrupo(grupo);
                    alumnoListNewAlumno = em.merge(alumnoListNewAlumno);
                    if (oldIdGrupoOfAlumnoListNewAlumno != null && !oldIdGrupoOfAlumnoListNewAlumno.equals(grupo)) {
                        oldIdGrupoOfAlumnoListNewAlumno.getAlumnoList().remove(alumnoListNewAlumno);
                        oldIdGrupoOfAlumnoListNewAlumno = em.merge(oldIdGrupoOfAlumnoListNewAlumno);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = grupo.getIdGrupo();
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

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<Alumno> alumnoListOrphanCheck = grupo.getAlumnoList();
            for (Alumno alumnoListOrphanCheckAlumno : alumnoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Grupo (" + grupo + ") cannot be destroyed since the Alumno " + alumnoListOrphanCheckAlumno + " in its alumnoList field has a non-nullable idGrupo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Profesor idProfesor = grupo.getIdProfesor();
            if (idProfesor != null) {
                idProfesor.getGrupoList().remove(grupo);
                idProfesor = em.merge(idProfesor);
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

    public Grupo findGrupo(String id) {
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
