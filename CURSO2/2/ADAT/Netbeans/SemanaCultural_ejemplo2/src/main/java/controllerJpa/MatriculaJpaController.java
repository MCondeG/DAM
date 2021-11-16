package controllerJpa;

import modeloJpa.*;
import excepciones.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class MatriculaJpaController implements Serializable {

    public MatriculaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Matricula matricula) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alumno idAlumno = matricula.getIdAlumno();
            if (idAlumno != null) {
                idAlumno = em.getReference(idAlumno.getClass(), idAlumno.getIdAlumno());
                matricula.setIdAlumno(idAlumno);
            }
            Taller idTaller = matricula.getIdTaller();
            if (idTaller != null) {
                idTaller = em.getReference(idTaller.getClass(), idTaller.getIdTaller());
                matricula.setIdTaller(idTaller);
            }
            em.persist(matricula);
            if (idAlumno != null) {
                idAlumno.getMatriculaList().add(matricula);
                idAlumno = em.merge(idAlumno);
            }
            if (idTaller != null) {
                idTaller.getMatriculaList().add(matricula);
                idTaller = em.merge(idTaller);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Matricula matricula) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Matricula persistentMatricula = em.find(Matricula.class, matricula.getIdMatricula());
            Alumno idAlumnoOld = persistentMatricula.getIdAlumno();
            Alumno idAlumnoNew = matricula.getIdAlumno();
            Taller idTallerOld = persistentMatricula.getIdTaller();
            Taller idTallerNew = matricula.getIdTaller();
            if (idAlumnoNew != null) {
                idAlumnoNew = em.getReference(idAlumnoNew.getClass(), idAlumnoNew.getIdAlumno());
                matricula.setIdAlumno(idAlumnoNew);
            }
            if (idTallerNew != null) {
                idTallerNew = em.getReference(idTallerNew.getClass(), idTallerNew.getIdTaller());
                matricula.setIdTaller(idTallerNew);
            }
            matricula = em.merge(matricula);
            if (idAlumnoOld != null && !idAlumnoOld.equals(idAlumnoNew)) {
                idAlumnoOld.getMatriculaList().remove(matricula);
                idAlumnoOld = em.merge(idAlumnoOld);
            }
            if (idAlumnoNew != null && !idAlumnoNew.equals(idAlumnoOld)) {
                idAlumnoNew.getMatriculaList().add(matricula);
                idAlumnoNew = em.merge(idAlumnoNew);
            }
            if (idTallerOld != null && !idTallerOld.equals(idTallerNew)) {
                idTallerOld.getMatriculaList().remove(matricula);
                idTallerOld = em.merge(idTallerOld);
            }
            if (idTallerNew != null && !idTallerNew.equals(idTallerOld)) {
                idTallerNew.getMatriculaList().add(matricula);
                idTallerNew = em.merge(idTallerNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = matricula.getIdMatricula();
                if (findMatricula(id) == null) {
                    throw new NonexistentEntityException("The matricula with id " + id + " no longer exists.");
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
            Matricula matricula;
            try {
                matricula = em.getReference(Matricula.class, id);
                matricula.getIdMatricula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The matricula with id " + id + " no longer exists.", enfe);
            }
            Alumno idAlumno = matricula.getIdAlumno();
            if (idAlumno != null) {
                idAlumno.getMatriculaList().remove(matricula);
                idAlumno = em.merge(idAlumno);
            }
            Taller idTaller = matricula.getIdTaller();
            if (idTaller != null) {
                idTaller.getMatriculaList().remove(matricula);
                idTaller = em.merge(idTaller);
            }
            em.remove(matricula);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Matricula> findMatriculaEntities() {
        return findMatriculaEntities(true, -1, -1);
    }

    public List<Matricula> findMatriculaEntities(int maxResults, int firstResult) {
        return findMatriculaEntities(false, maxResults, firstResult);
    }

    private List<Matricula> findMatriculaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Matricula.class));
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

    public Matricula findMatricula(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Matricula.class, id);
        } finally {
            em.close();
        }
    }

    public int getMatriculaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Matricula> rt = cq.from(Matricula.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
