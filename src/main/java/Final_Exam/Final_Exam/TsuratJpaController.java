/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Final_Exam.Final_Exam;

import Final_Exam.Final_Exam.exceptions.NonexistentEntityException;
import Final_Exam.Final_Exam.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Administrator
 */
public class TsuratJpaController implements Serializable {

    public TsuratJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Final_Exam_Final_Exam_jar_0.0.1-SNAPSHOTPU");

    TsuratJpaController() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tsurat tsurat) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tsurat);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTsurat(tsurat.getId()) != null) {
                throw new PreexistingEntityException("Tsurat " + tsurat + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tsurat tsurat) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tsurat = em.merge(tsurat);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tsurat.getId();
                if (findTsurat(id) == null) {
                    throw new NonexistentEntityException("The tsurat with id " + id + " no longer exists.");
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
            Tsurat tsurat;
            try {
                tsurat = em.getReference(Tsurat.class, id);
                tsurat.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tsurat with id " + id + " no longer exists.", enfe);
            }
            em.remove(tsurat);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tsurat> findTsuratEntities() {
        return findTsuratEntities(true, -1, -1);
    }

    public List<Tsurat> findTsuratEntities(int maxResults, int firstResult) {
        return findTsuratEntities(false, maxResults, firstResult);
    }

    private List<Tsurat> findTsuratEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tsurat.class));
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

    public Tsurat findTsurat(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tsurat.class, id);
        } finally {
            em.close();
        }
    }

    public int getTsuratCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tsurat> rt = cq.from(Tsurat.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
