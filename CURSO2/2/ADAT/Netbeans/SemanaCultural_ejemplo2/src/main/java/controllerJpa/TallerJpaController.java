
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


public class TallerJpaController implements Serializable {

    public TallerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Taller taller) {
        if (taller.getMatriculaList() == null) {
            taller.setMatriculaList(new ArrayList<Matricula>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Profesor profesorIdProfesor = taller.getProfesorIdProfesor();
            if (profesorIdProfesor != null) {
                profesorIdProfesor = em.getReference(profesorIdProfesor.getClass(), profesorIdProfesor.getIdProfesor());
                taller.setProfesorIdProfesor(profesorIdProfesor);
            }
            List<Matricula> attachedMatriculaList = new ArrayList<Matricula>();
            for (Matricula matriculaListMatriculaToAttach : taller.getMatriculaList()) {
                matriculaListMatriculaToAttach = em.getReference(matriculaListMatriculaToAttach.getClass(), matriculaListMatriculaToAttach.getIdMatricula());
                attachedMatriculaList.add(matriculaListMatriculaToAttach);
            }
            taller.setMatriculaList(attachedMatriculaList);
            em.persist(taller);
            if (profesorIdProfesor != null) {
                profesorIdProfesor.getTallerList().add(taller);
                profesorIdProfesor = em.merge(profesorIdProfesor);
            }
            for (Matricula matriculaListMatricula : taller.getMatriculaList()) {
                Taller oldIdTallerOfMatriculaListMatricula = matriculaListMatricula.getIdTaller();
                matriculaListMatricula.setIdTaller(taller);
                matriculaListMatricula = em.merge(matriculaListMatricula);
                if (oldIdTallerOfMatriculaListMatricula != null) {
                    oldIdTallerOfMatriculaListMatricula.getMatriculaList().remove(matriculaListMatricula);
                    oldIdTallerOfMatriculaListMatricula = em.merge(oldIdTallerOfMatriculaListMatricula);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Taller taller) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Taller persistentTaller = em.find(Taller.class, taller.getIdTaller());
            Profesor profesorIdProfesorOld = persistentTaller.getProfesorIdProfesor();
            Profesor profesorIdProfesorNew = taller.getProfesorIdProfesor();
            List<Matricula> matriculaListOld = persistentTaller.getMatriculaList();
            List<Matricula> matriculaListNew = taller.getMatriculaList();
            List<String> illegalOrphanMessages = null;
            for (Matricula matriculaListOldMatricula : matriculaListOld) {
                if (!matriculaListNew.contains(matriculaListOldMatricula)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Matricula " + matriculaListOldMatricula + " since its idTaller field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (profesorIdProfesorNew != null) {
                profesorIdProfesorNew = em.getReference(profesorIdProfesorNew.getClass(), profesorIdProfesorNew.getIdProfesor());
                taller.setProfesorIdProfesor(profesorIdProfesorNew);
            }
            List<Matricula> attachedMatriculaListNew = new ArrayList<Matricula>();
            for (Matricula matriculaListNewMatriculaToAttach : matriculaListNew) {
                matriculaListNewMatriculaToAttach = em.getReference(matriculaListNewMatriculaToAttach.getClass(), matriculaListNewMatriculaToAttach.getIdMatricula());
                attachedMatriculaListNew.add(matriculaListNewMatriculaToAttach);
            }
            matriculaListNew = attachedMatriculaListNew;
            taller.setMatriculaList(matriculaListNew);
            taller = em.merge(taller);
            if (profesorIdProfesorOld != null && !profesorIdProfesorOld.equals(profesorIdProfesorNew)) {
                profesorIdProfesorOld.getTallerList().remove(taller);
                profesorIdProfesorOld = em.merge(profesorIdProfesorOld);
            }
            if (profesorIdProfesorNew != null && !profesorIdProfesorNew.equals(profesorIdProfesorOld)) {
                profesorIdProfesorNew.getTallerList().add(taller);
                profesorIdProfesorNew = em.merge(profesorIdProfesorNew);
            }
            for (Matricula matriculaListNewMatricula : matriculaListNew) {
                if (!matriculaListOld.contains(matriculaListNewMatricula)) {
                    Taller oldIdTallerOfMatriculaListNewMatricula = matriculaListNewMatricula.getIdTaller();
                    matriculaListNewMatricula.setIdTaller(taller);
                    matriculaListNewMatricula = em.merge(matriculaListNewMatricula);
                    if (oldIdTallerOfMatriculaListNewMatricula != null && !oldIdTallerOfMatriculaListNewMatricula.equals(taller)) {
                        oldIdTallerOfMatriculaListNewMatricula.getMatriculaList().remove(matriculaListNewMatricula);
                        oldIdTallerOfMatriculaListNewMatricula = em.merge(oldIdTallerOfMatriculaListNewMatricula);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = taller.getIdTaller();
                if (findTaller(id) == null) {
                    throw new NonexistentEntityException("The taller with id " + id + " no longer exists.");
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
            Taller taller;
            try {
                taller = em.getReference(Taller.class, id);
                taller.getIdTaller();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The taller with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Matricula> matriculaListOrphanCheck = taller.getMatriculaList();
            for (Matricula matriculaListOrphanCheckMatricula : matriculaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Taller (" + taller + ") cannot be destroyed since the Matricula " + matriculaListOrphanCheckMatricula + " in its matriculaList field has a non-nullable idTaller field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Profesor profesorIdProfesor = taller.getProfesorIdProfesor();
            if (profesorIdProfesor != null) {
                profesorIdProfesor.getTallerList().remove(taller);
                profesorIdProfesor = em.merge(profesorIdProfesor);
            }
            em.remove(taller);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Taller> findTallerEntities() {
        return findTallerEntities(true, -1, -1);
    }

    public List<Taller> findTallerEntities(int maxResults, int firstResult) {
        return findTallerEntities(false, maxResults, firstResult);
    }

    private List<Taller> findTallerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Taller.class));
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

    public Taller findTaller(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Taller.class, id);
        } finally {
            em.close();
        }
    }

    public int getTallerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Taller> rt = cq.from(Taller.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
